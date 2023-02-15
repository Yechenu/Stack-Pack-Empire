import React from "react";
import { FieldArray } from "formik";
import { Grid, Typography } from "@material-ui/core";
import InputField from "../../../ApplicantDashboard/Section1Troubleshoot/FormFields/InputField";
import SelectField from "../../../ApplicantDashboard/Section1Troubleshoot/FormFields/SelectField";
import DatePickerField from "../../../ApplicantDashboard/Section1Troubleshoot/FormFields/SelectField";

const listCategoryOptions = [
  {
    value: undefined,
    label: "None",
  },
  {
    value: "listA",
    label: "List A: Identity and Employment Authorization",
  },
  {
    value: "listb",
    label: "List B: Identity",
  },
  {
    value: "listc",
    label: "List C: Employment Authorization",
  },
];



export default function DocumentInfoForm(props) {
  const {
    formField: {
      document: [
        {
          listCategory,
          documentTitle,
          issuingAuthority,
          documentNum,
          expirationDate,
        },
      ],
      employee_StartDate,
    },
  } = props;
  return (
    <React.Fragment>
      <Typography variant="h6" gutterBottom>
        Acceptable Document Information
      </Typography>

      <Typography variant="subtitle2">Document 1</Typography>

      <Grid container spacing={3}>
        <Grid item xs={12} sm={6}>
          <SelectField
            name={listCategory.name}
            label={listCategory.label}
            data={listCategoryOptions}
            fullWidth
          />
        </Grid>
        <Grid item xs={12} sm={6}>
          <InputField
            name={documentTitle.name}
            label={documentTitle.label}
            fullWidth
          />
        </Grid>
        <Grid item xs={12} sm={6}>
          <InputField
            name={issuingAuthority.name}
            label={issuingAuthority.label}
            fullWidth
          />
        </Grid>
        <Grid item xs={12} sm={6}>
          <InputField
            name={documentNum.name}
            label={documentNum.label}
            fullWidth
          />
        </Grid>
        <Grid item xs={12} sm={6}>
          <DatePickerField
            name={expirationDate.name}
            label={expirationDate.label}
            format="MM/dd/yyyy"
            views={["month", "day", "year"]}
            minDate={new Date()}
            maxDate={new Date("12/01/2031")}
            fullWidth
          />
        </Grid>
      </Grid>

      <Typography variant="subtitle2">Document 2</Typography>
      <Grid container spacing={3}>
        <Grid item xs={12} sm={6}>
          <SelectField
            name={listCategory.name}
            label={listCategory.label}
            data={listCategoryOptions}
            fullWidth
          />
        </Grid>
        <Grid item xs={12} sm={6}>
          <InputField
            name={documentTitle.name}
            label={documentTitle.label}
            fullWidth
          />
        </Grid>
        <Grid item xs={12} sm={6}>
          <InputField
            name={issuingAuthority.name}
            label={issuingAuthority.label}
            fullWidth
          />
        </Grid>
        <Grid item xs={12} sm={6}>
          <InputField
            name={documentNum.name}
            label={documentNum.label}
            fullWidth
          />
        </Grid>
        <Grid item xs={12} sm={6}>
          <DatePickerField
            name={expirationDate.name}
            label={expirationDate.label}
            format="MM/dd/yyyy"
            views={["month", "day", "year"]}
            minDate={new Date()}
            maxDate={new Date("12/01/2031")}
            fullWidth
          />
        </Grid>

        <Typography>
          {" "}
          <p>
            <b>Certification:</b> I attest, under penalty of perjury, that (1) I
            have examined the document(s) presented by the above-named employee,
            (2) the above-listed document(s) appear to be genuine and to relate
            to the employee named, and (3) to the best of my knowledge the
            employee is authorized to work in the United States.
          </p>
        </Typography>
        <Grid item xs={12} md={6}>
          <DatePickerField
            name={employee_StartDate.name}
            label={employee_StartDate.label}
            views={["month", "day", "year"]}
            minDate={new Date()}
            maxDate={new Date("12/01/2031")}
            fullWidth
          />
        </Grid>
      </Grid>
    </React.Fragment>
  );
}
