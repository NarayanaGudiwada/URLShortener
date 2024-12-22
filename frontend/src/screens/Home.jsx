import Card from "../components/Card";

const Home = () => {
  const handleSubmit = (e) => {
    e.preventDefault();
    const url = e.target[0].value;
    console.log(url);
  };

  return (
    <div
      className=" flex flex-grow justify-center items-center bg-orange-50 h-dvh
    "
    >
      <Card>
        <div className="flex flex-col items-center">
          <h1 className="text-xl font-bold text-orange-400 ">
            Enter <span className="text-orange-950">URL</span> to shorten
          </h1>
          <form onSubmit={handleSubmit}>
            <input
              type="text"
              className="w-72 h-10 rounded-lg p-2 mt-4 flex justify-center focus:border-orange-400"
              placeholder="Enter URL"
            />
            <button
              type="submit"
              className="w-72 h-10 bg-orange-400 text-white rounded-lg mt-4"
            >
              Shorten URL
            </button>
          </form>
        </div>
      </Card>
    </div>
  );
};

export default Home;
