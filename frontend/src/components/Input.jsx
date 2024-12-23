export const Input = ({inputref, placeholder, required}) => {
  return (
    <input
      type="text"
      ref={inputref}
      className="w-72  rounded-lg p-2 mt-4 focus:border border-orange-400 focus:outline-none"
      placeholder={placeholder}
      required = {required}
    />
  );
};
