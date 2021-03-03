import React from 'react';

import './index.css';

import { AnswerObject } from '../../App';

type Props = {
  question: string;
  answers: string[];
  callback: (e: React.MouseEvent<HTMLButtonElement>) => void;
  category: string;
  userAnswer: AnswerObject | undefined;
  questionNumber: number;
  totalQuestions: number;
}

const QuestionCard: React.FC<Props> = ({
  question,
  answers,
  callback,
  category,
  userAnswer,
  questionNumber,
  totalQuestions
}) => {
  return (
    <div className="wrapper">
      <p>
        Pergunta: {questionNumber} / {totalQuestions}
      </p>
      <p>Categoria: { category }</p>
      <p dangerouslySetInnerHTML={{ __html: question }} />
      <div className="button-wrapper">
        {answers.map((answer) => (
          <div key={answer}>
            <button
              disabled={!!userAnswer}
              value={answer}
              onClick={callback}
            >
              <span dangerouslySetInnerHTML={{ __html: answer }} />
            </button>
          </div>
        ))}
      </div>
    </div>
  );
}

export default QuestionCard;