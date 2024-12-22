import { useRef, useState } from "react";
import { SERVICE_API, SERVICE_URL } from "../../config/apiConfig";
import Card from "../components/Card";
import axios from "axios";

const Home = () => {
  const link = useRef();
  const [shortLink, setLink] = useState("");
  const handleSubmit = async (e) => {
    e.preventDefault();
    const url = link.current.value;
    if (!url) return;
    try {
      const response = await axios.post(SERVICE_API + "shorten", { url });
      setLink(response.data);
    } catch (error) {
      console.log(error);
    }
    link.current.value = "";
  };

  const handleCopy = () => {
    navigator.clipboard.writeText(SERVICE_URL + shortLink);
    alert("URL copied to clipboard!");
  };

  return (
    <div className="flex flex-grow justify-center items-center bg-orange-50 h-dvh">
      <Card>
        <div className="flex flex-col items-center">
          <h1 className="text-xl font-bold text-orange-400">
            Enter <span className="text-orange-950">URL</span> to shorten
          </h1>
          <form onSubmit={handleSubmit}>
            <input
              type="text"
              ref={link}
              className="w-72 h-10 rounded-lg p-2 mt-4 focus:border border-orange-400 focus:outline-none"
              placeholder="Enter URL"
            />
            <button
              type="submit"
              className="w-72 h-10 bg-orange-400 text-white rounded-lg mt-4"
            >
              Shorten URL
            </button>
          </form>

          {shortLink && (
            <div className="mt-4 flex items-center">
              <a
                href={SERVICE_URL + shortLink}
                target="_blank"
                className="mr-2"
              >
                {SERVICE_URL + shortLink}
              </a>
              <button
                onClick={handleCopy}
                className="bg-orange-400 text-white rounded-lg px-2 py-1"
              >
                Copy
              </button>
            </div>
          )}
        </div>
      </Card>
    </div>
  );
};

export default Home;
