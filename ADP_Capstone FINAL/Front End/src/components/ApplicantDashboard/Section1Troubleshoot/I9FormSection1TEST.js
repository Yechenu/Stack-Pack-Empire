import React, { useState } from "react";
import {
  Stepper,
  Step,
  StepLabel,
  Button,
  Typography,
  CircularProgress,
} from "@material-ui/core";
import { Formik, Form } from "formik";

import EmployeeInfoForm from "./Forms/EmployeeInfoTEST";
import AttestationForm from "./Forms/AttestationInfoTEST";
import PreparerSignatureForm from "./Forms/PreparerSignatureInfoTEST";
import SubmissionSuccess from "./SubmissionSuccess/SubmissionSuccessTEST";


import {validationSchema} from "./FormModel/validationSchemaTEST";
import {formInitialValues} from "./FormModel/formInitialValuesTEST";
import { section1FormModel } from "./FormModel/section1FormModelTEST";
import Section1Title from "./Forms/Section1TitleTEST"

import { useStyle } from "./Layout/syles";
import PageBanner from "../../Layout/PageBanner";


const FormTitles = [
  "Start Here",
  "Employee Information",
  "Employee Attestation",
  "Preparer Signature",
];
const { formId, formField } = section1FormModel;

function _renderStepContent(FormTitles) {
  switch (FormTitles) {
    case 0:
      return <Section1Title />;
    case 1:
      return <AttestationForm formField={formField} />;
    case 2:
      return <EmployeeInfoForm formField={formField} />;
    case 3:
      return <PreparerSignatureForm formField={formField} />;
    default:
      return <div>Not Found</div>;
  }
}

export default function I9FormSection1TEST() {
  const classes = useStyle();
  const [activeStep, setActiveStep] = useState(0);
  const currentValidationSchema = validationSchema[activeStep];
  const isLastStep = activeStep === FormTitles.length - 1;

  function _sleep(ms) {
    return new Promise((resolve) => setTimeout(resolve, ms));
  }

  async function _submitForm(values, actions) {
    await _sleep(1000);
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
      <PageBanner />
      Form I9: Section 1
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
