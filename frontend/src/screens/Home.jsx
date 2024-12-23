import { useRef, useState } from "react";
import { SERVICE_URL } from "../../config/apiConfig";
import Card from "../components/Card";
import axios from "axios";
import { Input } from "../components/Input";

const Home = () => {
  const link = useRef();
  const titleRef = useRef();
  const [shortLink, setLink] = useState("");
  const handleSubmit = async (e) => {
    e.preventDefault();
    const url = link.current.value;
    if (!url) return;
    try {
      const response = await axios.post(SERVICE_URL + "generate", {
        longUrl: url,
        title: titleRef.current.value,
      });
      setLink(response.data.shortUrl);
    } catch (error) {
      console.log(error);
    }
    link.current.value = "";
    titleRef.current.value = "";
  };

  const handleCopy = () => {
    navigator.clipboard.writeText(shortLink);
    alert("URL copied to clipboard!");
  };

  return (
    <div className="flex-1 flex flex-grow justify-center items-center bg-orange-50 h-full ">
      <Card>
        <div className="flex flex-col items-center">
          <h1 className="text-xl font-bold text-orange-400">
            Enter <span className="text-orange-950">URL</span> to shorten
          </h1>
          <form onSubmit={handleSubmit} className="flex flex-col items-center">
            <Input inputref={titleRef} placeholder={"Enter Title"} />
            <Input inputref={link} placeholder={"Enter URL"} required={true} />
            <button
              type="submit"
              className="w-72 h-10 bg-orange-400 text-white rounded-lg mt-4  hover:bg-orange-600 tarnsition-all hover:px-2 hover:py-2 duration-500 "
            >
              Shorten URL
            </button>
          </form>

          {shortLink && (
            <div className="mt-4 flex items-center">
              <a href={shortLink} target="_blank" className="mr-2">
                {shortLink}
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
