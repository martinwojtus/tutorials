export enum Position {
  CEO = 'CEO',
  SOFTWARE_ENGINEER = 'SOFTWARE_ENGINEER',
  SENIOR_JAVASCRIPT_DEVELOPER = 'SENIOR_JAVASCRIPT_DEVELOPER',
  INTEGRATION_SPECIALIST = 'INTEGRATION_SPECIALIST'
}

export const Position2LabelMapping: Record<Position, string> = {
  [Position.CEO]: "CEO",
  [Position.SOFTWARE_ENGINEER]: "Software engineer",
  [Position.SENIOR_JAVASCRIPT_DEVELOPER]: "Senior JavaScript Developer",
  [Position.INTEGRATION_SPECIALIST]: "Integration Specialist",
};