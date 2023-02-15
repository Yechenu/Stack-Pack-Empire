import { Formik, useField, validateYupSchema } from "formik";
// fieldInput props


 const CustomInput = ({ label, ...props }) => {
   const [field, meta] = useField(props);
   console.log(field);
   console.log(meta);
   
 
   return (
     <>
       <label htmlFor={props.id || props.name}>{label}</label>
       <input
         className="text-input"
         {...field}
         {...props}
       />

       {meta.touched && meta.error ? (
         <div className="error">{meta.error}</div>
       ) : null}
     </>
   );
 };
 export default CustomInput;