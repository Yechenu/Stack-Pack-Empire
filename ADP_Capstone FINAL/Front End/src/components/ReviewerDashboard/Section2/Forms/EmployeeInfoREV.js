import React from "react";
import { Grid, Typography } from "@material-ui/core";
import InputField from "../../../ApplicantDashboard/Section1Troubleshoot/FormFields/InputField";


export default function EmployeeInfoForm(props) {
  const {
    formField: {
      applicant_Id,
      employee_Fname,
      employee_Lname,
      employee_MI,
      employee_Citizenship,
    },
  } = props;

  return (
    <React.Fragment>
      <Typography variant="h6" gutterBottom>
        Employee Information
      </Typography>
      <Grid container spacing={3}>
        <Grid item xs={12} sm={6}>
          <InputField
            name={applicant_Id.name}
            label={applicant_Id.label}
            fullWidth
          />
        </Grid>
        <Grid item xs={12} sm={6}>
          <InputField
            name={employee_Fname.name}
            label={employee_Fname.label}
            fullWidth
          />
        </Grid>
        <Grid item xs={12} sm={6}>
          <InputField
            name={employee_Lname.name}
            label={employee_Lname.label}
            fullWidth
          />
        </Grid>

        <Grid item xs={12} sm={6}>
          <InputField
            name={employee_MI.name}
            label={employee_MI.label}
            fullWidth
          />
        </Grid>
        <Grid item xs={12} sm={6}>
          <InputField
            name={employee_Citizenship.name}
            label={employee_Citizenship.label}
            fullWidth
          />
        </Grid>
      </Grid>
    </React.Fragment>
  );
}