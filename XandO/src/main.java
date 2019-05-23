public class main {
    public static void main(String[] args) {
        char[][] fMap = new char[3][3] ;
        enter en = new enter();
        fMap = en.Nul();
        System.out.println("внизу находится ваше игровое поле, ваш знак - 'x', компьютера - 0 , попытайтесь обыграть ;)");
        System.out.println("для хода , после сообщения 'ваш ход', укажите стобец и строку , куда ходите сходить");
        en.soutMap(fMap);
        igra igra = new igra();
        igra.getStarted(fMap);
    }
}
