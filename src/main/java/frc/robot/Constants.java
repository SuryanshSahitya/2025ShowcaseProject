package frc.robot;

public final class Constants {

    public static final class DriveConstants {
        public static final int kLeftMotorPort = 0;
        public static final int kRightMotorPort = 1;
        public static final int kLeftEncoderChannelA = 0;
        public static final int kLeftEncoderChannelB = 1;
        public static final int kRightEncoderChannelA = 2;
        public static final int kRightEncoderChannelB = 3;
        public static final double kEncoderTick2Meter = 1.0 / 4096.0 * 0.128 * Math.PI;
    }

    public static final class OIConstants {
        public static final int kDriverJoystickPort = 0;

        public static final int kArcadeDriveSpeedAxis = 1;
        public static final int kArcadeDriveTurnAxis = 3;
    }
}
