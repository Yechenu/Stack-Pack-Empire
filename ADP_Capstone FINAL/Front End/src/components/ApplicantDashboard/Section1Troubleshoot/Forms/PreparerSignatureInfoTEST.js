import React from "react";
import { Grid, Typography } from "@material-ui/core";
import InputField from "../FormFields/InputField";
import SelectField from "../FormFields/SelectField";
import CheckboxField from "../FormFields/CheckboxField";
import DatePickerField from "../FormFields/DatePickerField";

const preparerCertOptions = [

  {
    value: "NoPreparer",
    label: "I did not use a preparer or translator",
  },
  {
    value: "preparerCert",
    label:
      "A preparer(s) and/or translator(s) assisted the employee in completing Section 1",
  },
  
];

export default function PreparerSignatureForm(props) {
  const {
    formField: {
      preparerCert,
      preparerLname,
      preparerFname,
      preparerAddress,
      preparerCity,
      preparerState,
      preparerZip,
      dateCompleted,
      preparerEsign,
    },
  } = props;

  return (
    <React.Fragment>
      <Typography variant="h6" gutterBottom>
        Preparer and/or Translator Certification
      </Typography>
      <div>
        {" "}
        <Typography>
          Fields below must be completed and signed when preparers and/or
          translators assist an employee in completing Section 1. (Select one)
        </Typography>
      </div>
      <Grid container spacing={3}>
        <Grid item xs={12} sm={6}>
          <SelectField
            name={preparerCert.name}
            label={preparerCert.label}
            data={preparerCertOptions}
            fullWidth
          />
        </Grid>

        <Typography>
          <strong>
            I attest, under penalty of perjury, that I have assisted in the
            completion of Section 1 of this form and that to the best of my
            knowledge the information is true and correct.
          </strong>
        </Typography>

        <Grid item xs={12} sm={6}>
          <InputField
            name={preparerLname.name}
            label={preparerLname.label}
            fullWidth
          />
        </Grid>

        <Grid item xs={12} sm={6}>
          <InputField
            name={preparerFname.name}
            label={preparerFname.label}
            fullWidth
          />
        </Grid>

        <Grid item xs={12} sm={6}>
          <InputField
            name={preparerAddress.name}
            label={preparerAddress.label}
            fullWidth
          />
        </Grid>

        <Grid item xs={12} sm={6}>
          <InputField
            name={preparerCity.name}
            label={preparerCity.label}
            fullWidth
          />
        </Grid>

        <Grid item xs={12} sm={6}>
          <InputField
            name={preparerState.name}
            label={preparerState.label}
            fullWidth
          />
        </Grid>

        <Grid item xs={12} sm={6}>
          <InputField
            name={preparerZip.name}
            label={preparerZip.label}
            fullWidth
          />
        </Grid>

        <Grid item xs={12} md={6}>
          <DatePickerField
            name={dateCompleted.name}
            label={dateCompleted.label}
            format="yyyy/MM/dd"
            views={["year", "month", "day"]}
            minDate={new Date()}
            maxDate={new Date("2050/12/31")}
            fullWidth
          />
        </Grid>

        <Grid item xs={12} sm={6}>
          <InputField
            name={preparerEsign.name}
            label={preparerEsign.label}
            fullWidth
          />
        </Grid>
      </Grid>
    </React.Fragment>
  );
}