import { useEffect, useState } from "react";
import "./App.css";
import Product from "./components/Product";

function App() {
  const [data, setData] = useState();

  const onClickHandel = () => {
    setData(data + 1);
  };

  useEffect(() => {
    setData(1);
  }, []);

  return (
    <div className="App">
      <header className="App-header">
        <Product name="Apple iPhone" price="900"></Product>
        <Product name="MI m20" price="200"></Product>
        {data}
        <button onClick={() => onClickHandel()}>Click Me</button>
      </header>
    </div>
  );
}

export default App;
