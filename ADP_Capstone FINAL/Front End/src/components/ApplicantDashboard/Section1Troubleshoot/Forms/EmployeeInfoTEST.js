import React from "react";
import { Grid, Typography } from "@material-ui/core";
import InputField from "../FormFields/InputField";
import DatePickerField  from "../FormFields/DatePickerField";


export default function EmployeeInfoForm(props) {
  const {
    formField: {
      employee_Fname,
      employee_Lname,
      employee_MI,
      employee_Oname,
      employee_Address,
      employee_AptNum,
      employee_City,
      employee_State,
      employee_Zip,
      employee_DOB,
      employee_SSN,
      employee_Email,
      employee_Phone,
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
            name={employee_Oname.name}
            label={employee_Oname.label}
            fullWidth
          />
        </Grid>
        <Grid item xs={12}>
          <InputField
            name={employee_Address.name}
            label={employee_Address.label}
            fullWidth
          />
        </Grid>
        <Grid item xs={12} sm={6}>
          <InputField
            name={employee_AptNum.name}
            label={employee_AptNum.label}
            fullWidth
          />
        </Grid>
        <Grid item xs={12} sm={6}>
          <InputField
            name={employee_City.name}
            label={employee_City.label}
            fullWidth
          />
        </Grid>
        <Grid item xs={12} sm={6}>
          <InputField
            name={employee_State.name}
            label={employee_State.label}
            fullWidth
          />
        </Grid>
        <Grid item xs={12} sm={6}>
          <InputField
            name={employee_Zip.name}
            label={employee_Zip.label}
            fullWidth
          />
        </Grid>
        <Grid item xs={12} md={6}>
          <DatePickerField
            name={employee_DOB.name}
            label={employee_DOB.label}
            format="yyyy/MM/dd"
            views={["year", "month", "day"]}
            minDate={new Date()}
            maxDate={new Date("today")}
            fullWidth
          />
        </Grid>
        <Grid item xs={12} sm={6}>
          <InputField
            name={employee_SSN.name}
            label={employee_SSN.label}
            fullWidth
          />
        </Grid>
        <Grid item xs={12} sm={6}>
          <InputField
            name={employee_Email.name}
            label={employee_Email.label}
            fullWidth
          />
        </Grid>
        <Grid item xs={12} sm={6}>
          <InputField
            name={employee_Phone.name}
            label={employee_Phone.label}
            fullWidth
          />
        </Grid>
      </Grid>
    </React.Fragment>
  );
}
