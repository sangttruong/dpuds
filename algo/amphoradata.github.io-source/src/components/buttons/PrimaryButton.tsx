import React from "react";
import classnames from "classnames";

import "./buttons.css";
interface PrimaryButtonProps {
    className?: string;
}
export const PrimaryButton: React.FC<PrimaryButtonProps> = ({
    children,
    className,
}) => <div className={classnames("buttons", className)}>{children}</div>;
