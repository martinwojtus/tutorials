module.exports = {
  extends: ['react-app', 'react-app/jest', 'prettier'],
  plugins: ['prettier'],
  rules: {
    'prettier/prettier': 'warn',
    'no-console': 'warn',
    '@typescript-eslint/no-explicit-any': 'warn',
  },
};
