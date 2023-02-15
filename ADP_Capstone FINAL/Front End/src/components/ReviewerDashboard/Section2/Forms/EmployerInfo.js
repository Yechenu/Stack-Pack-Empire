import React from "react";
import { Grid, Typography } from "@material-ui/core";
import InputField from "../../../ApplicantDashboard/Section1Troubleshoot/FormFields/InputField";


export default function EmployeeInfoForm(props) {
  const {
    formField: {
      employer_Lname,
      employer_Fname,
      employerTitle,
      employer_BusinessName,
      employer_BusinessAddress,
      employer_BusinessCity,
      employer_BusinessState,
      employer_BusinessZip,
      employer_Signature,
      dateCompleted,
    },
  } = props;

  return (
    <React.Fragment>
      <Typography variant="h6" gutterBottom>
        Employer Information
      </Typography>
      <Grid container spacing={3}>
        {/*Form section 2 begins*/}
        <Grid item xs={12} sm={6}>
          <InputField
            name={employer_Fname.name}
            label={employer_Fname.label}
            fullWidth
          />
        </Grid>

        {/* Employeee Last Name */}
        <Grid item xs={12} sm={6}>
          <InputField
            name={employer_Lname.name}
            label={employer_Lname.label}
            fullWidth
          />
        </Grid>
        <Grid item xs={12} sm={6}>
          <InputField
            name={employerTitle.name}
            label={employerTitle.label}
            fullWidth
          />
        </Grid>
        <Grid item xs={12} sm={6}>
          <InputField
            name={employer_BusinessName.name}
            label={employer_BusinessName.label}
            fullWidth
          />
        </Grid>
        <Grid item xs={12} sm={6}>
          <InputField
            name={employer_BusinessAddress.name}
            label={employer_BusinessAddress.label}
            fullWidth
          />
        </Grid>
        <Grid item xs={12} sm={6}>
          <InputField
            name={employer_BusinessCity.name}
            label={employer_BusinessCity.label}
            fullWidth
          />
        </Grid>
        <Grid item xs={12} sm={6}>
          <InputField
            name={employer_BusinessState.name}
            label={employer_BusinessState.label}
            fullWidth
          />
        </Grid>
        <Grid item xs={12} sm={6}>
          <InputField
            name={employer_BusinessZip.name}
            label={employer_BusinessZip.label}
            fullWidth
          />
        </Grid>
        <Grid item xs={12} sm={6}>
          <InputField
            name={dateCompleted.name}
            label={dateCompleted.label}
            fullWidth
          />
        </Grid>

        <Grid item xs={12} sm={6}>
          <InputField
            name={employer_Signature.name}
            label={employer_Signature.label}
            fullWidth
          />
        </Grid>
      </Grid>
    </React.Fragment>
  );
}