import * as Yup from "yup";
import { section2FormModel } from "./section2Model";

const {
  formField: {
    applicant_Id,
    employee_Fname,
    employee_Lname,
    employee_MI,
    employee_Citizenship,
document: [{
   listCategory,
    documentTitle,
    issuingAuthority,
    documentNum,
    expirationDate,
 }],
   
    additional_Inf,
    employee_StartDate,

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
} = section2FormModel;

export const section2Schema = Yup.object().shape({
  [applicant_Id.name]: Yup.string( ).required(),
  [employee_Fname.name]: Yup.string()
    .min(2, "Name must be at lest 2 characters long")
    .required("Required"),
  [employee_Lname.name]: Yup.string().required(),
  [employee_MI.name]: Yup.string().required(),
  [employee_Citizenship.name]: Yup.string().required(),
  document:
  //  Yup.object().shape({
    Yup.array().of(
      Yup.object().shape({
        [listCategory.name]: Yup.string().required(),
        [documentTitle.name]: Yup.string().required(),
        [issuingAuthority.name]: Yup.string().required(),
        [documentNum.name]: Yup.number().required(),
        [expirationDate.name]: Yup.date().required(),
  })),

  [additional_Inf.name]: Yup.number().required(),
  [employee_StartDate.name]: Yup.date()
    .transform()
    .typeError("please enter a valid date")
    .required(),

  [employerTitle.name]: Yup.string().required("*Required*"),
  [employer_Lname.name]: Yup.string().required(" * Required *"),
  [employer_Fname.name]: Yup.string().required(" * Required *"),
  [employer_BusinessName.name]: Yup.string().required(" * Required *"),
  [employer_BusinessAddress.name]: Yup.string().required(" * Required *"),
  [employer_BusinessCity.name]: Yup.string().required(" * Required *"),
  [employer_BusinessState.name]: Yup.string().required(" * Required *"),
  [employer_BusinessZip.name]: Yup.string().required(" * Required *"),
  [employer_Signature.name]: Yup.string()
    .required(" * Required *")
    .matches(
      /^data:image\/(?:gif|png|jpeg|bmp|webp|svg\+xml)(?:;charset=utf-8)?;base64,(?:[A-Za-z0-9]|[+/])+={0,2}/,
      "Signature must be png"
    ),
  [dateCompleted.name]: Yup.date()
    .transform()
    .typeError("please enter a valid date")
    .required(),
});
