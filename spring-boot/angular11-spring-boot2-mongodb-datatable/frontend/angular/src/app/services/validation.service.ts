export class ValidationService {
  static getValidatorErrorMessage(validatorName: string, validatorValue?: any) {
    let config = {
      required: 'This field is required',
      pattern: `Incorrect value, required pattern: ${validatorValue.requiredPattern}`
    };

    return config[validatorName];
  }
}