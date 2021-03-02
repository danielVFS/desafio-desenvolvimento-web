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

export enum Difficulty {
  EASY = "fácil",
  MEDIUM = "médio",
  HARD = "difícil",
}

export const fetchQuizQuestions = async (
  amount: number, difficulty: Difficulty
) => {
  const endpoint = `https://opentdb.com/api.php?amount=${amount}&difficulty=${difficulty}&type=multiple`;
  const endpointTest = `http://localhost:8080/questions`;

  const data = await (await fetch(endpoint)).json();
  const dataTest = await (await fetch(endpointTest)).json();

  console.log(data);
  console.log(dataTest);

  return dataTest.map((question: Question) => ({
    ...question,
    answers: shuffleArray([
      ...question.incorrect_answers,
      question.correct_answer
    ])
  }))
}