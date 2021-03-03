import React, { useState } from 'react';
import Select from 'react-select';

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

const App = () => {
  const [loading, setLoading] = useState(false);
  const [questions, setQuestions] = useState<QuestionState[]>([]);
  const [number, setNumber] = useState(0);
  const [userAnswers, setUsersAnswers] = useState<AnswerObject[]>([]);
  const [score, setScore] = useState(0);
  const [firstTry, setFirstTry] = useState(true);
  const [gameOver, setGameOver] = useState(true);
  const [howManyQuestionOption, setHowManyQuestionOption] = useState(2);

  const startTrivia = async () => {
    setLoading(true);
    setGameOver(false);
    setFirstTry(false);

    const newQuestions = await fetchQuizQuestions(
      howManyQuestionOption,
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

    if (nextQuestion === howManyQuestionOption) {
      setGameOver(true);
      setFirstTry(false);
    } else {
      setNumber(nextQuestion);
    }
  }

  const howManyQuestionsOptions = [
    { value: 1, label: "1" },
    { value: 2, label: "2" },
    { value: 3, label: "3" },
    { value: 4, label: "4" },
  ];

  const handleSelectedHowManyQuestion = (howManyQuestionOption) => {
    setHowManyQuestionOption(howManyQuestionOption.value);
  }

  return (
    <div className="container">
      <h2 className="title"> Quiz game</h2>
      {firstTry || userAnswers.length === howManyQuestionOption ? (
        <>
          <button className="start" onClick={startTrivia}>Iniciar Jogo</button>
          <div className="selectArea">
            <Select
            options={howManyQuestionsOptions}
            placeholder="Quantas questões você deseja ?"
            onChange={handleSelectedHowManyQuestion}
            autoFocus={true}
          />
          </div>
        </>
      ) : null}
      {!gameOver ? <p className="score">Placar: { score }</p> : null}
      {loading && <p>Carregando perguntas do quiz...</p>}
      {!loading && !gameOver && (
        <QuestionCard
        questionNumber={number + 1}
        totalQuestions={howManyQuestionOption}
        question={questions[number].question}
        answers={questions[number].answers}
        userAnswer={userAnswers ? userAnswers[number] : undefined}
        callback={checkAnswer}
      />
      )}
      {!gameOver && !loading && userAnswers.length === number + 1 && number !== howManyQuestionOption - 1 ? (
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
      {score === howManyQuestionOption ? 
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
