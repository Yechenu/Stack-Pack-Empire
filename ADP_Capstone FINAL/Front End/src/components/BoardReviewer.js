import React, { useState, useEffect } from "react";

import UserService from "../services/user.service";
import EventBus from "../common/EventBus";
import ReviewerDashboard from "./ReviewerDashboard/ReviewerDashboard";

const BoardReviewer = () => {
  const [content, setContent] = useState("");

  useEffect(() => {
    UserService.getReviewerBoard().then(
      (response) => {
        setContent(response.data);
      },
      (error) => {
        const _content =
          (error.response &&
            error.response.data &&
            error.response.data.message) ||
          error.message ||
          error.toString();

        setContent(_content);

        if (error.response && error.response.status === 401) {
          EventBus.dispatch("logout");
        }
      }
    );
  }, []);

  return (
    <div className="container">
      <header className="jumbotron">
        <h3>{content}</h3>
        <ReviewerDashboard/>
      </header>
    </div>
  );
};

export default BoardReviewer;
