import { Typography } from 'antd';
import Layout, { Content, Header } from 'antd/lib/layout/layout';
import React from 'react';
import styled from 'styled-components';
import { colors } from '../shared/SharedUtils';
import Taskboard from '../taskboard/Taskboard';

const StyledLayout = styled(Layout)`
  /* We can't use "height: 100vh; width: 100vw;" here.
  Otherwise, when there is a horizontal scrollbar etc, 
  because that we set a constant height, there will be a vertical one too.  */
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
`;

const StyledHeader = styled(Header)`
  display: flex;
  align-items: center;
  background-color: #fff;
`;

const StyledContent = styled(Content)`
  background-color: ${colors.primary[6]};
`;

function App() {
  return (
    <StyledLayout>
      <StyledHeader>
        <Typography.Title level={3} type="secondary">
          Drag & Drop Taskboard
        </Typography.Title>
      </StyledHeader>
      <StyledContent>
        <Taskboard />
      </StyledContent>
    </StyledLayout>
  );
}

export default App;
