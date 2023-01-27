package frc.robot.subsystems;

<<<<<<< Updated upstream
import edu.wpi.first.math.filter.LinearFilter;
=======
import edu.wpi.first.math.geometry.Pose2d;
>>>>>>> Stashed changes
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase {
  private NetworkTableInstance networkTableInstance = NetworkTableInstance.getDefault();
  private NetworkTable limelight = networkTableInstance.getTable("limelight");
  private NetworkTableEntry botpose = limelight.getEntry("botpose");
  private NetworkTableEntry stream = limelight.getEntry("stream");

<<<<<<< Updated upstream

  public Limelight() {
    stream.setNumber(2);//Pour mettre l'image de la limelight en PiP
    SmartDashboard.putString("Pose", getPos().toString());
    
  }

  public Pose3d getPos(){
    double[] temp = { 0, 0, 0 ,0,0,0};//default for getEntry
=======
  private Pose3d test = new Pose3d();

  public Limelight() {
    stream.setNumber(2);//Pour mettre l'image de la limelight en PiP
    
    
  }

  @Override
  public void periodic() {


  }

  public Pose3d getPos(){
    double[] temp = { 0,0,0,0,0,0};//default for getEntry
>>>>>>> Stashed changes
    double[] result = botpose.getDoubleArray(temp);
    Translation3d tran3d = new Translation3d(result[0], result[1], result[2]);
    Rotation3d r3d = new Rotation3d(result[3], result[4], result[5]);
    Pose3d p3d = new Pose3d(tran3d, r3d);
    
<<<<<<< Updated upstream
   return p3d;

  } 
=======
    return p3d;
  } 

  public double[] publicationPose3d(Pose3d input){
    Pose2d inputSimple = input.toPose2d();
    double[] output = {inputSimple.getX(), inputSimple.getY(), inputSimple.getRotation().getDegrees()};
    return output;

  }
>>>>>>> Stashed changes
}