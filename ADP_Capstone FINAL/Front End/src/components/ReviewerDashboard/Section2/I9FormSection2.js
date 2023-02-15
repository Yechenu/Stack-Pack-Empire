import React, { useState } from "react";
import {
  Stepper,
  Step,
  StepLabel,
  Button,
  CircularProgress,
} from "@material-ui/core";
import { Formik, Form } from "formik";
import DocumentInfoForm from "./Forms/DocumentInfo";
import EmployeeInfoForm from "./Forms/EmployeeInfoREV"
import EmployerInfo from "./Forms/EmployerInfo";
import Section2Title from "./Forms/Section2Title";
import SubmissionSuccess from "../../ApplicantDashboard/Section1Troubleshoot/SubmissionSuccess/SubmissionSuccessTEST";


import { section2Schema } from "./FormModel/validationSchema2";
import { section2FormModel } from "./FormModel/section2Model";
import { formInitialValues } from "./FormModel/formIntitialValues2"
import FormServices from "../../../services/form.services";

import { useStyle } from "./Layout/syles";


  //variable that tracks the form pages. also know as "step"
 
  // apply validationSchema to each page in the Array

  const FormTitles = [
    "I-9 Form: Section 2",
    "Employee Information",
    "Document",
    "Employer Information",
  ];
  const { formId, formField } = section2FormModel;
  //  returns the html form
  function _renderStepContent(FormTitles) {
    switch (FormTitles) {
      case 0:
        return <Section2Title />;
      case 1:
         return <EmployeeInfoForm formField={formField} />;
      case 2:
        return <DocumentInfoForm formField={formField} />;
      case 3:
       return <EmployerInfo formField={formField} />;
      default:
        return <div>Not Found</div>;
    }
  }
  export default function I9FormSection2() {
  const classes = useStyle();
  const [activeStep, setActiveStep] = useState(0);
  const currentValidationSchema = section2Schema[activeStep];
  const isLastStep = activeStep === FormTitles.length - 1;
 function _sleep(ms) {
    return new Promise((resolve) => setTimeout(resolve, ms));
  }

   async function _submitForm(values, actions) {
    await _sleep(1000);
    FormServices.completeSection2(values);
    alert(JSON.stringify(values, null, 2));
    actions.setSubmitting(false);

    setActiveStep(activeStep + 1);
  }

 function _handleSubmit(values, actions) {
    if (isLastStep) {
      _submitForm(values, actions);
    } else {
      setActiveStep(activeStep + 1);
      actions.setTouched({});
      actions.setSubmitting(false);
    }
  }

  function _handleBack() {
    setActiveStep(activeStep - 1);
  }


  return (
    <React.Fragment>
      Form I9: Section 2
      <Stepper activeStep={activeStep} className={classes.stepper}>
        {FormTitles.map((label) => (
          <Step key={label}>
            <StepLabel>{label}</StepLabel>
          </Step>
        ))}
      </Stepper>
      <React.Fragment>
        {activeStep === FormTitles.length ? (
          <SubmissionSuccess />
        ) : (
          <Formik
            initialValues={formInitialValues}
            validationSchema={currentValidationSchema}
            onSubmit={_handleSubmit}>
            {({ isSubmitting }) => (
              <Form id={formId}>
                {_renderStepContent(activeStep)}


                <div className={classes.buttons}>
                  {activeStep !== 0 && (
                    <Button onClick={_handleBack} className={classes.button}>
                      Back
                    </Button>
                  )}
                  <div className={classes.wrapper}>
                    <Button
                      disabled={isSubmitting}
                      type="submit"
                      variant="contained"
                      color="primary"
                      className={classes.button}>
                      {isLastStep ? "Submit" : "Next"}
                    </Button>
                    {isSubmitting && (
                      <CircularProgress
                        size={24}
                        className={classes.buttonProgress}
                      />
                    )}
                  </div>
                </div>
              </Form>
            )}
          </Formik>
        )}
      </React.Fragment>
    </React.Fragment>
  );
}
