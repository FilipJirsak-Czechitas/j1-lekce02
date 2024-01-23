package cz.czechitas.java.lekce02;

import cz.czechitas.java.lekce02.engine.Turtle;

public class HlavniProgram {
  private Turtle zofka;

  public void start() {
    zofka = new Turtle();

    this.nakresliDomecek();

    // posun doleva na začátek prasátka
    zofka.penUp();
    zofka.turnLeft(90.0);
    zofka.move(200.0);
    zofka.turnRight(90.0);
    zofka.penDown();

    this.nakresliPrasatko();

    // posun nahoru doprava na střed Slunce
    zofka.penUp();
    zofka.move(400.0);
    zofka.turnRight(90.0);
    zofka.move(200.0);
    zofka.turnLeft(90.0);
    zofka.penDown();

    nakresliHvezdicku();

    zofka.penUp();
    zofka.turnRight(180.0);
    zofka.move(600.0);
    zofka.turnRight(180.0);
    zofka.penDown();

    nakresliKolecko(200, 24);

  }

  public void nakresliPrasatko() {
    zofka.turnLeft(90.0);
    this.nakresliDomecek();
    this.nakresliNozky();
    zofka.move(150.0);
    this.nakresliNozky();
    zofka.turnRight(90.0);
  }

  public void nakresliNozky() {
    zofka.turnLeft(45.0);
    zofka.move(40.0);
    zofka.turnRight(180.0);
    zofka.move(40.0);
    zofka.turnRight(90.0);
    zofka.move(40.0);
    zofka.turnRight(180.0);
    zofka.move(40.0);
    zofka.turnLeft(45.0);
  }


  public void nakresliDomecek() {
    for (int i = 0; i < 4; i++) {
      zofka.move(150.0);
      zofka.turnRight(90.0);
    }

    zofka.penUp();
    zofka.move(150.0);
    zofka.penDown();

    zofka.turnRight(30.0);
    zofka.move(150.0);
    zofka.turnRight(120.0);
    zofka.move(150.0);

    zofka.turnRight(30.0);
    zofka.penUp();
    zofka.move(150.0);
    zofka.turnRight(90.0);
    zofka.move(150.0);
    zofka.turnRight(90.0);
    zofka.penDown();
  }

  /**
   * Nakreslí „kolečko“ – pravidelný mnohoúhelník se zadaným „poloměrem“ a počten stran.
   *
   * Výpočet délky strany se provádí tak, že si mnohoúhelník rozdělím na trojúhelníky tvořené jednou
   * stranou mnohoúhelníku a spojnicí sousedních vrcholů se středem. Jde tedy o rovnoramenný trojúhelík.
   * Tento trojúhelník se rozdělí na dva shodné pravoúhlé trojúhelníky tím, že se vztyčí kolmice ze středu
   * strany mnohoúhelníku, které prochází středem trojúhelníku.
   * Přepona tohoto trojúhelníku je spojnice středu a vrcholu mnohoúhelníku, jedna přepona je polovina strany
   * mnohoúhelníku, druhá přepona je ona kolmice. Známý úhel je úhel u středu mnohoúhelníky, který je polovinou
   * středového úhlu mnohoúhelníku.
   *
   * @param polomer Poloměr kolečka – vzdálenost mezi středem a brcholem mnohoúhelíku.
   * @param pocetStran Počet stran mnohoúhelníku. Doporučeno volit číslo, které je celočíselným dělitelem 360.
   */
  public void nakresliKolecko(int polomer, int pocetStran) {
    zofka.penUp();
    zofka.move(polomer);
    zofka.penDown();

    // o kolik stupňů se musí želva otočit, když má kreslit další stranu mnohoúhelníku
    // zároven je to velikost úhlu, který má vrchol ve středu mnohoúhelníku a spojuje střed a dva sousedící vrcholy mnohoúhelníku
    int uhel = 360 / pocetStran;

    // sinus úhlu = délka protilehlé odvěsny / délka přepony
    // úhel = polovina vnitřního úhlu
    // přepona = spojnice středu a vrcholu
    // odvěsna = polovina strany mnohoúhelníku
    int delkaStrany = (int) (Math.sin(Math.PI * (double) uhel / 360d) * polomer * 2);

    zofka.turnRight(90);
    for (int i = 0; i < pocetStran; i++) {
      zofka.move(delkaStrany);
      zofka.turnRight(uhel);
    }
    zofka.turnLeft(90);

  }

  public void nakresliHvezdicku() {
    for (int i = 0; i < 8; i++) {
      nakresliPaprsek();
      zofka.turnRight(45.0);
    }
  }

  public void nakresliPaprsek() {
    zofka.move(50);
    zofka.turnRight(180.0);
    zofka.move(50);
    zofka.turnRight(180.0);
  }

  public static void main(String[] args) {
    new HlavniProgram().start();
  }

}
