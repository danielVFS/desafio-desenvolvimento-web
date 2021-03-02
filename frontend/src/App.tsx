import React, { useState } from 'react';

import './App.css';

import QuestionCard from './components/QuestionCard';
import Overlay from './components/Overlay';

import loseImg from './assets/images/lose.jpg';
import winImg from './assets/images/win.jpg';

import { fetchQuizQuestions } from './API';

import { QuestionState, Difficulty } from './API';

export type AnswerObject = {
  question: string;
  answer: string;
  correct: boolean;
  correctAnswer: string;
}

const TOTAL_QUESTIONS = 1;

const App = () => {
  const [loading, setLoading] = useState(false);
  const [questions, setQuestions] = useState<QuestionState[]>([]);
  const [number, setNumber] = useState(0);
  const [userAnswers, setUsersAnswers] = useState<AnswerObject[]>([]);
  const [score, setScore] = useState(0);
  const [firstTry, setFirstTry] = useState(true);
  const [gameOver, setGameOver] = useState(true);

  const startTrivia = async () => {
    setLoading(true);
    setGameOver(false);
    setFirstTry(false);

    const newQuestions = await fetchQuizQuestions(
      TOTAL_QUESTIONS,
      Difficulty.EASY,
    );

    setQuestions(newQuestions);
    setScore(0);
    setUsersAnswers([]);
    setNumber(0);
    setLoading(false);
  }

  const checkAnswer = (e: React.MouseEvent<HTMLButtonElement>) => {
    if (!gameOver) {
      // getting the user answer
      const answer = e.currentTarget.value;
      
      // check correct answer
      const correct = questions[number].correct_answer === answer;

      // check if answer is incorrect
      if (!correct) {
        setGameOver(true);
        setFirstTry(false);
      }
      
      // add score if is correct
      if (correct) setScore(prev => prev + 1);

      //save answer in the array for user answers
      const answerObject = {
        question: questions[number].question,
        answer,
        correct,
        correctAnswer: questions[number].correct_answer,
      };
      setUsersAnswers((prev) => [...prev, answerObject]);
    }
  }

  const nextQuestion = () => {
    const nextQuestion = number + 1;

    if (nextQuestion === TOTAL_QUESTIONS) {
      setGameOver(true);
      setFirstTry(false);
    } else {
      setNumber(nextQuestion);
    }
  }
  
  return (
    <div className="container">
      <h2 className="title"> Quiz game</h2>
      {firstTry || userAnswers.length === TOTAL_QUESTIONS ? (
        <button className="start" onClick={startTrivia}>Iniciar Jogo</button>
      ) : null}
      {!gameOver ? <p className="score">Placar: { score }</p> : null}
      {loading && <p>Carregando perguntas do quiz...</p>}
      {!loading && !gameOver && (
        <QuestionCard
        questionNumber={number + 1}
        totalQuestions={TOTAL_QUESTIONS}
        question={questions[number].question}
        answers={questions[number].answers}
        userAnswer={userAnswers ? userAnswers[number] : undefined}
        callback={checkAnswer}
      />
      )}
      {!gameOver && !loading && userAnswers.length === number + 1 && number !== TOTAL_QUESTIONS - 1 ? (
        <button className="next" onClick={nextQuestion}>Próxima Pergunta</button>
      ) : null}
      {gameOver && !firstTry &&
        <Overlay
        callback={startTrivia}
        image={loseImg}
        title="Não Foi Dessa Vez"
        textButton="Recomeçar Quiz"
        />
      }
      {score === TOTAL_QUESTIONS ? 
        <Overlay
        callback={startTrivia}
        image={winImg}
        title="Parabéns, Você ganhou!"
        textButton="Jogar Novamente"
        />
        : null
      }
    </div>
  );
}

export default App;
