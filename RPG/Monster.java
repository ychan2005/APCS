public class Monster{
  private int health;
  private int str; // modifier for damage rolls
  private int precision; //modifier for attack rolls
  private int ac; // Armor Class. Used to determine if attack misses.

  public Monster(){
    str = modifier();
    precision = modifier();
    health = 15 + modifier();
    ac = 10 + modifier();
  }

  public int rollDie(int sideNum){
    return (int) (Math.random() * sideNum) + 1;
  }

  public int modifier(){
    return (int) (Math.random() * 4);
  }

  public int getAC(){ //used in Protagonist
    return ac;
  }

  public boolean isAlive(){
    return health > 0;
  }

  public void takeDamage(int d){ //used in Protagonist
    health -= d;
  }

  public int attack(Protagonist p){
    int damage = 0;
    // regular attack
    if (! p.getSpecial()){
      // attack roll. 1d20 + precision. Greater than opponent AC = hit.
      if (rollDie(20) + precision > p.getAC()){
        damage = rollDie(4) + str; //dmg roll. 1d4 + str
      }
    // special attack
    } else {
      if (rollDie(20) + precision > p.getAC()){
        damage = (rollDie(4) + rollDie(4) + str); //dmg roll. 2d4 + str
      }
    }
    p.takeDamage(damage); //protag takes damage
    return damage; //show damage dealt.
  }


}
