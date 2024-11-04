//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/*
Задача:
        Напишите программу, которая:
        1. Запрашивает у пользователя ввод 5 строк, которые будут храниться в массиве.
        2. Использует блок try-catch, чтобы:
        Поймать ArrayIndexOutOfBoundsException, если пользователь пытается получить доступ к элементу массива, который не существует.
        Поймать NullPointerException, если пользователь вводит пустую строку (например, пытается вывести длину пустой строки).
        3. В конце программы, в блоке finally, выводит сообщение "Обработка завершена", которое должно выводиться всегда.
        4. Программа должна выводить длины введенных строк, если они не пустые, и выводить сообщение "Строка пустая" для пустых строк.
*/

/*
Задача*:
        Напишите программу, которая:
        1. Создает класс Student с полями name (имя студента) и grade (оценка).
        2. Создает массив из 5 объектов Student.
        3. Запрашивает у пользователя ввести имя и оценку для каждого студента, используя цикл.
        4. Использует блок try-catch для обработки следующих исключений:
Исключение, если пользователь вводит некорректное значение (например, не число) для оценки.
Исключение, если пользователь вводит пустое имя.
        5. В конце, в блоке finally, программа выводит сообщение "Обработка завершена", независимо от того, произошли ли исключения или нет.
        6. После завершения ввода, программа должна вывести список всех студентов и их оценок.
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Первая задачка
        /*
        try {
            Scanner scanner = new Scanner(System.in);
            String[] array = new String[5];

            for (int i = 0; i < array.length; i++) {
                array[i] = scanner.nextLine();
                // Выбрасываем ошибку NullPointerException, можно было ловить ошибку конца строки, например array[i].endsWith("something")
                checkNullException(array[i]);
            }
            // Ловим ошибку ArrayIndexOutOfBoundsException, в случае, если нет пустой строки
            System.out.println(array[6]);
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println("Была поймана одна из ошибок \n" + e);
        } finally {
            System.out.println("Обработка завершена");
        }
        */

        // Вторая задачка
        try {
            Scanner scanner = new Scanner(System.in);
            Student[] student = new Student[5];

            for (int i = 0; i < student.length; i++) {
                student[i] = new Student();
                // Ловим ошибку NullPointerException
                System.out.println("Введите имя " + (i+1) + " студента ");
                student[i].setName(scanner.nextLine());
                if (scanner.hasNextLine())
                    scanner.nextLine();
                checkNullException(student[i].getName());

                // Ловим ошибку InputMismatchException
                System.out.println("Введите оценку студента ");
                student[i].setGrade(scanner.nextInt());
                if (scanner.hasNextLine())
                    scanner.nextLine();
            }

            for (int i = 0; i < student.length; i++) {
                student[i].outputStudentGrades();
            }

        } catch (InputMismatchException | NullPointerException e) {
            System.out.println("Была поймана одна из ошибок \n" + e);
        } catch (IndexOutOfBoundsException indexException) {
            System.out.println("Была поймана ошибка доступа к несуществующему элемента массива" + indexException);
        } finally {
            System.out.println("Обработка завершена");
        }
    }

    public static void checkNullException(String line) {
        if (line.isEmpty()) {
            throw new NullPointerException("Строка не должна быть пустой");
        }
    }
}