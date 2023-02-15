import React from "react";
import { Grid, Typography } from "@material-ui/core";
import InputField from "../FormFields/InputField";
import SelectField from "../FormFields/SelectField";
import DatePickerField from "../FormFields/DatePickerField";

const attestationOptions = [
  {
value: undefined, label: 'None'
  },
  {
    value: "US_Citizen",
    label: " 1. A citizen of the United States",
  },
  {
    value: "Noncitizen",
    label: "2. A noncitizen national of the United States (See instructions)",
  },
  {
    value: "Permanent_Resident",
    label: " 3. A lawful permanent resident",
  },
  
     { value: "Authorized_Alien", 
     label: "  4. An Alien authorized to work"
     },
  
];


export default function AttestationForm(props) {
  const {
    formField: {
      employee_Attestation,
      USCISnum,
      expirationDate,
      formI94_AdmissionNum,
      foreignPassportNum,
      countryOfInsuance,
    }
    
  } = props;
  return (
    <React.Fragment>
      <Typography variant="h6" gutterBottom>
        Employee Attestation
      </Typography>
      <div>
        {" "}
        <p>
          I am aware that federal law provides for imprisonment and/or fines for
          false statements or use of false documents in connection with the
          completion of this form.
          <br /> I attest, under penalty of perjury, that I am (check one of the
          following boxes):
        </p>
      </div>
      <Grid container spacing={3}>
        <Grid item xs={12} sm={6}>
          <SelectField
            name={employee_Attestation.name}
            label={employee_Attestation.label}
            data={attestationOptions}
            fullWidth
          />
        </Grid>
        <Grid item xs={12}>
          <p>If you selected (3) provided the following.</p>
        </Grid>
        <Grid item xs={12} sm={6}>
          <InputField name={USCISnum.name} label={USCISnum.label} fullWidth />
        </Grid>
        <Grid item xs={12}>
          <p>
            If you are an alien authorized to work, provided the following.{" "}
            <br />
            <em>
              Some aliens may write "N/A" in the expiration date field. (See
              instructions)
            </em>
          </p>
        </Grid>
        <Grid item xs={12} md={6}>
          <DatePickerField
            name={expirationDate.name}
            label={expirationDate.label}
            format="yyyy/MM/dd"
            views={["year", "month", "day"]}
            minDate={new Date()}
            maxDate={new Date("2050/12/31")}
            fullWidth
          />
        </Grid>
        <p>
          <em>
            Aliens authorized to work must provide only one of the following
            document numbers to complete Form I-9: An Alien Registration
            Number/USCIS Number OR Form I-94 Admission Number OR Foreign
            Passport Number
          </em>
        </p>
        <Grid item xs={12} sm={6}>
          <InputField name={USCISnum.name} label={USCISnum.label} fullWidth />
          <p> OR </p>
        </Grid>
        <Grid item xs={12} />

        <Grid item xs={12} sm={6}>
          <InputField
            name={formI94_AdmissionNum.name}
            label={formI94_AdmissionNum.label}
            fullWidth
          />
          <p> OR </p>
        </Grid>
        <Grid item xs={12} />
        <Grid item xs={6}>
          <InputField
            name={foreignPassportNum.name}
            label={foreignPassportNum.label}
            fullWidth
          />
          <p> OR </p>
        </Grid>
        <Grid item xs={6}>
          <InputField
            name={countryOfInsuance.name}
            label={countryOfInsuance.label}
            fullWidth
          />
        </Grid>
      </Grid>
    </React.Fragment>
  );
}
