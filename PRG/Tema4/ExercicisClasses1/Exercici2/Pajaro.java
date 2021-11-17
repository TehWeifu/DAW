class Pajaro {
    public  void  setEdad(int e){
        edad = e;
    }

    public void printEdad(){
        System.out.println(edad);
    }

    public void setcolor(char c) {
        color = c;	        // ERROR. La propietat s'anomena "color", amb minúscula
    }

    private char color;     // ERROR? No es pot accedir a la propietat color
    private int edad;
}
