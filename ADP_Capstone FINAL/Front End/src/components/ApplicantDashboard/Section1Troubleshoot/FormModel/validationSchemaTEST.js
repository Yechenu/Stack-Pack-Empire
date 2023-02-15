import * as Yup from "yup";
import { section1FormModel } from "./section1FormModelTEST";

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
    employee_Attestation,
    USCISnum,
    expirationDate,
    formI94_AdmissionNum,
    foreignPassportNum,
    countryOfInsuance,
    employee_Signature,
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
} = section1FormModel;

export const validationSchema = Yup.object().shape({
  [employee_Fname.name]: Yup.string()
    .max(15, "Must be 15 characters or less")
    .required(`${employee_Fname.requiredErrorMsg}`),

  [employee_Lname.name]: Yup.string()
    .max(20, "Must be 20 characters or less")
    .required(`${employee_Lname.requiredErrorMsg}`),

  [employee_MI.name]: Yup.string().required(`${employee_MI.requiredErrorMsg}`),

  [employee_Oname.name]: Yup.string().required(
    `${employee_Oname.requiredErrorMsg}`
  ),
  [employee_Address.name]: Yup.string().required(
    `${employee_Address.requiredErrorMsg}`
  ),

  [employee_AptNum.name]: Yup.string().required(),
  [employee_City.name]: Yup.string().required(),
  [employee_State.name]: Yup.string().required(),
  [employee_Zip.name]: Yup.string().required(
    `${employee_Zip.requiredErrorMsg}`
  ),
  // .test("len", `${employee_Zip.invalidErrorMsg}`),
  [employee_DOB.name]: Yup.date()
    .transform()
    .typeError(`${employee_DOB.invalidErrorMsg}`)
    .required(`${employee_DOB.requiredErrorMsg}`),
  [employee_SSN.name]: Yup.string().required(),
  [employee_Email.name]: Yup.string()
    .email(`${employee_Email.invalidErrorMsg}`)
    .required(`${employee_Email.requiredErrorMsg}`).validate,
  [employee_Phone.name]: Yup.string()
    .required(`${employee_Phone.requiredErrorMsg}`)
    .validate(`${employee_Phone.invalidErrorMsg}`),
  [employee_Attestation.name]: Yup.string()
    .oneOf([])
    .required(`${employee_Attestation.requiredErrorMsg}`),

  [expirationDate.name]: Yup.date(`${expirationDate.invalidErrorMsg}`).required(
    `${expirationDate.requiredErrorMsg}`
  ),
  [USCISnum.name]: Yup.number().required(`${USCISnum.requiredErrorMsg}`),
  [formI94_AdmissionNum.name]: Yup.number().required(
    `${formI94_AdmissionNum.requiredErrorMsg}`
  ),
  [foreignPassportNum.name]: Yup.number().required(
    `${foreignPassportNum.requiredErrorMsg}`
  ),
  [countryOfInsuance.name]: Yup.string().required(
    `${countryOfInsuance.requiredErrorMsg}`
  ),
  [employee_Signature.name]: Yup.string()
    .required(`${employee_Signature.requiredErrorMsg}`)
    .matches(
      /^data:image\/(?:gif|png|jpeg|bmp|webp|svg\+xml)(?:;charset=utf-8)?;base64,(?:[A-Za-z0-9]|[+/])+={0,2}/,
      "Signature must be png"
    ),
  // preparerCert: Yup.array().max(1).of(Yup.string().required().required()),
  [preparerCert.name]: Yup.string()
    .oneOf([])
    .required(`${preparerCert.requiredErrorMsg}`),

  [preparerLname.name]: Yup.string().required(
    `${preparerLname.requiredErrorMsg}`
  ),
  [preparerFname.name]: Yup.string().required(
    `${preparerFname.requiredErrorMsg}`
  ),
  [preparerAddress.name]: Yup.string().required(
    `${preparerAddress.requiredErrorMsg}`
  ),

  [preparerCity.name]: Yup.string()
    .nullable()
    .required(`${preparerCity.requiredErrorMsg}`),

  [preparerState.name]: Yup.string().required(
    `${preparerState.requiredErrorMsg}`
  ),
  [preparerZip.name]: Yup.string()
    .required(`${preparerZip.requiredErrorMsg}`)
    .test(
      "len",
      `${preparerZip.invalidErrorMsg}`,
      (val) => val && val.length === 5
    ),
  [dateCompleted.name]: Yup.date()
    .transform()
    .typeError(`${dateCompleted.invalidErrorMsg}`)
    .required(`${dateCompleted.requiredErrorMsg}`),
  [preparerEsign.name]: Yup.string()
    .required(`${preparerEsign.requiredErrorMsg}`)
    .matches(
      /^data:image\/(?:gif|png|jpeg|bmp|webp|svg\+xml)(?:;charset=utf-8)?;base64,(?:[A-Za-z0-9]|[+/])+={0,2}/,
      "Signature must be png"
    ),
});
