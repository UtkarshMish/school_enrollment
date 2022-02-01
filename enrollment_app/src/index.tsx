import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import App from "./ui/App";

ReactDOM.hydrate(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById("root"),
);

/**
 * This is the app entry point.
 * Do edit if you are not sure what is going on here. Please edit `/src/ui/App.tsx` to start.
 */
