const Card = ({ children }) => {
  return (
    <div className="bg-orange-200 rounded-lg shadow-lg p-8">
      {children}
    </div>
  );
};

export default Card;
