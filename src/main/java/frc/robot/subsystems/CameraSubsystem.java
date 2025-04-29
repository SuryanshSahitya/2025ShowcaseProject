package frc.robot.subsystems;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.cscore.CvSource;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cscore.VideoMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CameraSubsystem extends SubsystemBase {
    public CameraSubsystem() {
        // Start the camera server
        UsbCamera camera = CameraServer.startAutomaticCapture();
        UsbCamera camera2 = CameraServer.startAutomaticCapture();
        camera.setResolution(640, 480);
        camera2.setResolution(640,480);


    }
}
