import { Tooltip, TooltipProps } from 'antd';
import React from 'react';

type BaseTooltipProps = TooltipProps;

function BaseTooltip(props: BaseTooltipProps) {
  return <Tooltip mouseEnterDelay={1.5} {...props} />;
}

export default BaseTooltip;
