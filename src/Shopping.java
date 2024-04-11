import java.util.Scanner;

public class Shopping {
    public static void main(String[] args){
        System.out.println("Вас приветствует список покупок!");
        String[] shoppingList = new String[8];
        Scanner scanner = new Scanner(System.in);
        int productCount = 0;

        while (true) {
            System.out.println("Выберите одну из команд:");
            System.out.println("1. Добавить товар в список");
            System.out.println("2. Показать список");
            System.out.println("3. Очистить список");
            System.out.println("4. Завершить работу");

            int actionNumber = scanner.nextInt();

            if (actionNumber == 1) {
                System.out.println("Пожалуйста, введите название товара без пробела. Если название товара состоит из нескольких слов, используйте символ нижнего подчеркивания: '_' между словами.");
                String productName = scanner.next();
                boolean isAlreadyIn = false;//флаг, обозначающий что товар не встречается в массиве
                if (productCount > 0) {
                    for (int i = 0; i < productCount; i++) {
                        if (shoppingList[i].equals(productName)) {//проверка на повторяемость в массиве
                            System.out.println("Такой товар уже есть в списке");
                            isAlreadyIn = true;
                        }
                    }
                }
                if(!isAlreadyIn) {
                    shoppingList[productCount] = productName;
                    System.out.println("Товар " + productName + " добавлен в список под номером " + (productCount + 1));
                    productCount++;
                }

                if (productCount >= 8) { //условие для увеличения массива
                    String s;//временная переменная для хранения значений массива
                    String[] array = new String[shoppingList.length];//временный массив
                    for (int i = 0; i < productCount; i++) {//в данном цикле переносим данные из основного массива во временный
                        s = shoppingList[i];
                        array[i] = s;
                    }
                    shoppingList = new String[array.length + 1];//заменяем основной массив новым с дополнительной "ячейкой"
                    for (int i = 0; i < productCount; i++) {//цикл для заполнения основного массива данными из временного
                        s = array[i];
                        shoppingList[i] = s;
                    }
                }
                System.out.println();
            }



            else if (actionNumber == 2){
                if (productCount == 0){
                    System.out.println("Ваш список товаров пока пуст");
                }
                else {
                    for (int i = 0; i < productCount; i++) {
                        System.out.println((i+1) + ". " + shoppingList[i]);
                    }
                }
                System.out.println();
            }

            else if (actionNumber == 3){
                shoppingList = new String[8];
                System.out.println("Теперь Ваш список пуст");
                productCount = 0;
                System.out.println();

            } else if (actionNumber == 4) {
                break;

            }else {
                System.out.println("Неизвестная команда");
                System.out.println();
            }
        }
    }
}

