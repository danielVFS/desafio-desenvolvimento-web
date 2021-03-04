import { shuffleArray } from './utils';

export type Question = {
  category: string;
  correct_answer: string;
  difficulty: string;
  incorrect_answers: string[];
  question: string;
  type: string;
}

export type QuestionState = Question & { answers: string[] }

export const fetchQuizQuestions = async (
  amount: number, category: string
) => {
  
  const endpoint = `http://localhost:8080/questions?category=${category}&amount=${amount}`;

  const data = await (await fetch(endpoint)).json();

  return data.map((question: Question) => ({
    ...question,
    answers: shuffleArray([
      ...question.incorrect_answers,
      question.correct_answer
    ])
  }))
}