const Card = ({ children }) => {
  return (
    <div className="size-96 h-60 bg-orange-200 rounded-lg shadow-lg p-8">
      {children}
    </div>
  );
};

export default Card;
