//**************************************************** ***************
// MagazineRack.java Author:. Lewis/Loftus/Cocking
//
// Driver to exercise the MagazineList collection.
//**************************************************** ***************
public class MagazineRack
{
  //----------------------------------------------------------------
  //Creates a MagazineList object, adds several magazines to the
  //list, then prints it~
  //----------------------------------------------------------------
  public static void main (String[] args)
  {
    MagazineList rack = new MagazineList();
    rack.add(new Magazine("Time"));
    rack.add (new Magazine("Woodworking Today"));
    rack.add (new Magazine("Communications of the ACM"));
    rack.add (new Magazine("House and Garden"));
    rack.add (new Magazine ("GQ" ));
    
    System.out.println (rack);
    
    rack.delete(new Magazine("Communications of the ACM"));
    
    System.out.println(rack);
    
    rack.insert(new Magazine("SWAG"), "Woodworking Today");
    rack.insert(new Magazine("YOLO"));
    System.out.println(rack);
                              }
}