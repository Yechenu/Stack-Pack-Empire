import React from "react";
import { Formik, Field, FieldArray } from "formik";
// import { formIntitialValues } from "../Form Data/formIntitialValues";
// import { section2Schema } from "../Form Data/section2Schema";
// import CustomSelect from "../../../common/CustomSelect";
// import CustomInput from "../../../common/CustomFieldInput";


const onSubmit = async (_values, actions) => {
  await new Promise((resolve) => setTimeout(resolve, 1000));
  actions.resetForm();
};

function DocumentInfo() {
  return (
    <div className="employee-info-containter">
      <Formik
        initialValues={{
          document: [
            {
              listCategory: "",
              documentTitle: "",
              issuingAuthority: "",
              documentNum: "",
              expirationDate: "",
            },
          ],
        }}
        onSubmit={(value) => {
          console.log(value);
        }}>
        {(formikProps) => (
          <form onSubmit={formikProps.handleSubmit}>
            <FieldArray name="document">
              {(fieldArrayProps) => (
                <>
                  <div>
                    <button
                      type="button"
                      onClick={() =>
                        fieldArrayProps.push(
                          { documentTitle: "" },
                          { issuingAuthority: "" },
                          { documentNum: "" },
                          { documentTitle: "" }
                        )
                      }>
                      Add
                    </button>
                  </div>

                  {formikProps.values.document.map((document, index) => (
                    <Field name={`document.${index}.documentTitle`}>
                      {(fieldProps) => (
                        <div>
                          <lable {...fieldProps.lable}> Document Title </lable>
                          <input
                            placeholder="Document Title"
                            {...fieldProps.field}
                          />

                          <button
                            type="button"
                            onClick={() => fieldArrayProps.remove(index)}>
                            Remove
                          </button>
                        </div>
                      )}
                    </Field>
                  ))}
                </>
              )}
            </FieldArray>
            <button type="button">Submit</button>
          </form>
        )}
      </Formik>
    </div>
  );
}
export default DocumentInfo;
