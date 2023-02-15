import React from "react";
import { Formik, Form } from "formik";
// import { formIntitialValues2 } from "../Form Data/formIntitialValues2";
import CustomInput from "../../../../common/CustomFieldInput";
// import { section2Schema } from "../FormModel/section2Schema";

const onSubmit = async (_values, actions) => {
  await new Promise((resolve) => setTimeout(resolve, 1000));
  actions.resetForm();
};

function EmployeeInfoRV() {
  return (
    <div className="employee-info-containter">
      <Formik
        // initialValues={formIntitialValues2}
        // validationSchema={section2Schema}
        onSubmit={onSubmit}>
        {/* passes the props from the "CustomFieldInput" file */}
        {(props) => (
          <Form>
            {/*Form section 2 begins*/}
            {/* Employeee Last Name */}

            <div className="form_input">
              <CustomInput
                label="Employee Last Name (Family Name)"
                name="employee_Lname "
                type="text"
                placeholder="Enter Last Name"
              />
            </div>

            <div className="form_input">
              <CustomInput
                label=" Employee First Name (Given Name)"
                name="employee_Fname "
                type="text"
                placeholder="Enter First Name"
              />
            </div>

            <div className="form_input">
              <CustomInput
                label=" Employee Middle Initial"
                name="employee_MI "
                type="text"
                placeholder="Enter Middle Name"
              />
            </div>

            <div className="form_input">
              <CustomInput
                label="   Employee Citizenship/Immigration Status"
                name="employee_Citizenship "
                type="text"
                placeholder="Enter Citizenship/Immigration Status"
              />
            </div>
            <div>
              {" "}
              <p>
                <b>Certification:</b> I attest, under penalty of perjury, that
                (1) I have examined the document(s) presented by the above-named
                employee, (2) the above-listed document(s) appear to be genuine
                and to relate to the employee named, and (3) to the best of my
                knowledge the employee is authorized to work in the United
                States.
              </p>
            </div>
            <div className="form_input">
              <CustomInput
                label="Employee First Day of Employment"
                name="employee_StartDate "
                type="date"
                placeholder="yyyy/mm/dd"
              />
            </div>
          </Form>
        )}
      </Formik>
    </div>
  );
}
export default EmployeeInfoRV;
