import React from 'react';
import { Typography } from '@material-ui/core';

function SubmissionSuccess() {
  return (
    <React.Fragment>
      <Typography variant="h5" gutterBottom>
        You've Completed Section 1 of the Form-I9
      </Typography>
      <Typography variant="subtitle1">
        Return to the applicant dashboard to submit acceptable documentation and view Section 2 status.
      </Typography>
    </React.Fragment>
  );
}

export default SubmissionSuccess;
