import React from 'react';

import './index.css';

type Props = {
  callback: (e: React.MouseEvent<HTMLButtonElement>) => void;
  image: string;
  title: string;
  textButton: string;
}

const Overlay: React.FC<Props> = ({ callback, image, title, textButton }) => {
  return (
    <div className="background">
      <div className="modal-wrapper fade-in">
        <img src={image} alt="lose" className="image"/>
        <div className="modal-content">
          <h1>{title}</h1>
          <button onClick={callback}>{textButton}</button>
        </div>
      </div>
    </div>
  );
}

export default Overlay;