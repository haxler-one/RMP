
import .math.PI
import kotlin.math.sqrt

// 1. Класс "Человек"
class Person(var name: String, var age: Int, var gender: String) {
    fun printInfo() {
        println("Name: $name, Age: $age, Gender: $gender")
    }

    fun increaseAge() {
        age++
    }
4
    fun changeName(newName: String) {
        name = newName
    }
}

// 2. Наследование: Класс "Работник" и "Менеджер"
open class Worker(name: String, age: Int, gender: String, var salary: Double) : Person(name, age, gender) {
    fun printWorkerInfo() {
        printInfo()
        println("Salary: $salary")
    }
}

class Manager(name: String, age: Int, gender: String, salary: Double, var subordinates: List<Worker>) : Worker(name, age, gender, salary) {
    fun printManagerInfo() {
        printWorkerInfo()
        println("Number of Subordinates: ${subordinates.size}")
    }
}

// 3. Полиморфизм: Животные
interface Animal {
    fun makeSound()
}

class Dog : Animal {
    override fun makeSound() {
        println("Woof!")
    }
}

class Cat : Animal {
    override fun makeSound() {
        println("Meow!")
    }
}

class Cow : Animal {
    override fun makeSound() {
        println("Moo!")
    }
}

// 4. Абстрактный класс "Транспорт"
abstract class Transport {
    abstract fun move()
}

class Car : Transport() {
    override fun move() {
        println("Car is driving")
    }
}

class Bike : Transport() {
    override fun move() {
        println("Bike is cycling")
    }
}

// 5. Класс "Книга" и "Библиотека"
data class Book(val title: String, val author: String, val year: Int)

class Library {
    private val books = mutableListOf<Book>()

    fun addBook(book: Book) {
        books.add(book)
    }

    fun searchByAuthor(author: String): List<Book> {
        return books.filter { it.author == author }
    }

    fun searchByYear(year: Int): List<Book> {
        return books.filter { it.year == year }
    }
}

// 6. Инкапсуляция: Банк
class BankAccount(private val accountNumber: String, private var balance: Double) {
    fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
            println("Deposited $amount. New balance: $balance")
        } else {
            println("Invalid deposit amount.")
        }
    }

    fun withdraw(amount: Double) {
        if (amount > 0 && amount <= balance) {
            balance -= amount
            println("Withdrew $amount. New balance: $balance")
        } else {
            println("Insufficient funds or invalid amount.")
        }
    }

    fun getBalance(): Double {
        return balance
    }
}

// 7. Счетчик объектов
class Counter {
    companion object {
        private var count = 0
    }

    init {
        count++
    }

    fun getCount(): Int {
        return count
    }
}

// 8. Площадь фигур
abstract class Shape {
    abstract fun getArea(): Double
}

class Circle(val radius: Double) : Shape() {
    override fun getArea(): Double {
        return PI * radius * radius
    }
}

class Rectangle(val width: Double, val height: Double) : Shape() {
    override fun getArea(): Double {
        return width * height
    }
}

// 9. Наследование: Животные и их движения
open class Animal2 {
    open fun move() {
        println("Animal is moving")
    }
}

class Fish : Animal2() {
    override fun move() {
        println("Fish is swimming")
    }
}

class Bird : Animal2() {
    override fun move() {
        println("Bird is flying")
    }
}

class Dog2 : Animal2() {
    override fun move() {
        println("Dog is running")
    }
}

// 10. Работа с коллекциями: Университет
data class Student(val name: String, val group: String, val grade: Double)

class University {
    private val students = mutableListOf<Student>()

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun sortBy(comparator: Comparator<Student>):List<Student> {
        return students.sortedWith(comparator)
    }

    fun filterByGrade(minGrade: Double): List<Student> {
        return students.filter { it.grade >= minGrade }
    }
}

// 11. Класс "Магазин"
data class Product(val name: String, val price: Double, var quantity: Int)

class Store {
    private val products = mutableListOf<Product>()

    fun addProduct(product: Product) {
        products.add(product)
    }

    fun removeProduct(name: String) {
        products.removeIf { it.name == name }
    }

    fun findProductByName(name: String): Product? {
        return products.find { it.name == name }
    }
}

// 12. Интерфейс "Платежная система"
interface PaymentSystem {
    fun pay(amount: Double): Boolean
    fun refund(amount: Double): Boolean
}

class CreditCard(private val cardNumber: String, private val expiryDate: String, private val cvv: String) : PaymentSystem {
    override fun pay(amount: Double): Boolean {
        println("Paying $amount with Credit Card $cardNumber")
        return true // Simulate successful payment
    }

    override fun refund(amount: Double): Boolean {
        println("Refunding $amount to Credit Card $cardNumber")
        return true // Simulate successful refund
    }
}

class PayPal(private val email: String) : PaymentSystem {
    override fun pay(amount: Double): Boolean {
        println("Paying $amount with PayPal $email")
        return true // Simulate successful payment
    }

    override fun refund(amount: Double): Boolean {
        println("Refunding $amount to PayPal $email")
        return true // Simulate successful refund
    }
}

// 13. Генерация уникальных идентификаторов
class UniqueID {
    companion object {
        private var nextId = 1
    }

    val id: Int = nextId++
}

// 14. Класс "Точка" и "Прямоугольник"
data class Point(val x: Double, val y: Double)

class Rectangle2(val topLeft: Point, val bottomRight: Point) {
    fun getArea(): Double {
        val width = bottomRight.x - topLeft.x
        val height = bottomRight.y - topLeft.y
        return width * height
    }
}

// 15. Комплексные числа
data class ComplexNumber(val real: Double, val imaginary: Double) {
    operator fun plus(other: ComplexNumber): ComplexNumber {
        return ComplexNumber(real + other.real, imaginary + other.imaginary)
    }

    operator fun minus(other: ComplexNumber): ComplexNumber {
        return ComplexNumber(real - other.real, imaginary - other.imaginary)
    }

    operator fun times(other: ComplexNumber): ComplexNumber {
        val newReal = (real * other.real) - (imaginary * other.imaginary)
        val newImaginary = (real * other.imaginary) + (imaginary * other.real)
        return ComplexNumber(newReal, newImaginary)
    }

    operator fun div(other: ComplexNumber): ComplexNumber {
        val denominator = (other.real * other.real) + (other.imaginary * other.imaginary)
        val newReal = ((real * other.real) + (imaginary * other.imaginary)) / denominator
        val newImaginary = ((imaginary * other.real) - (real * other.imaginary)) / denominator
        return ComplexNumber(newReal, newImaginary)
    }
}

// 16. Перегрузка операторов: Матрица
class Matrix(private val rows: Int, private val cols: Int, private val data: Array<DoubleArray>) {

    init {
        require(rows > 0 && cols > 0) { "Rows and columns must be positive" }
        require(data.size == rows && data[0].size == cols) { "Data size must match rows and columns" }
    }

    operator fun plus(other: Matrix): Matrix {
        require(rows == other.rows && cols == other.cols) { "Matrices must have the same dimensions for addition" }
        val resultData = Array(rows) { DoubleArray(cols) }
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                resultData[i][j] = data[i][j] + other.data[i][j]
            }
        }
        return Matrix(rows, cols, resultData)
    }

    operator fun times(other: Matrix): Matrix {
        require(cols == other.rows) { "Number of columns in the first matrix must equal the number of rows in the second matrix for multiplication" }
        val resultRows = rows
        val resultCols = other.cols
        val resultData = Array(resultRows) { DoubleArray(resultCols) }
        for (i in 0 until resultRows) {
            for (j in 0 until resultCols) {
                for (k in 0 until cols) {
                    resultData[i][j] += data[i][k] * other.data[k][j]
                }
            }
        }
        return Matrix(resultRows, resultCols, resultData)
    }

    fun printMatrix() {
        for (row in data) {
            println(row.joinToString(" "))
        }
    }
}

// 17. Создание игры с использованием ООП
open class Weapon(val name: String, val damage: Int) {
    open fun attackMessage(): String {
        return "Attacks with $name for $damage damage!"
    }
}

class Sword(damage: Int) : Weapon("Sword", damage) {
    override fun attackMessage(): String {
        return "Slashes with a sword for $damage damage!"
    }
}

open class Character(open var health: Int, val weapon: Weapon, val name: String){
    fun attack(target: Character) {
        println("$name ${weapon.attackMessage()}")
        target.health -= weapon.damage
        println("${target.name} has ${target.health} health left.")
    }

    open fun isAlive(): Boolean{
        return health > 0
    }
}

class Enemy(health: Int, weapon: Weapon, name: String) : Character(health, weapon, name) {
    override fun isAlive(): Boolean{
        return health > 0
    }
}

class Player(health: Int, weapon: Weapon, name: String) : Character(health, weapon, name) {
    override fun isAlive(): Boolean{
        return health > 0
    }
}

// 18. Автоматизированная система заказов
data class Product2(val name: String, val price: Double)

data class OrderItem(val product: Product2, val quantity: Int) {
    fun getTotalPrice(): Double {
        return product.price * quantity
    }
}

class Order(val customer: Customer) {
    private val items = mutableListOf<OrderItem>()

    fun addItem(item: OrderItem) {
        items.add(item)
    }

    fun getTotalCost(): Double {
        return items.sumOf { it.getTotalPrice() }
    }

    fun getOrderItems(): List<OrderItem> {
        return items.toList() // Return a copy to prevent modification
    }
}

class Customer(val name: String, val email: String) {
    private val orderHistory = mutableListOf<Order>()

    fun placeOrder(order: Order) {
        orderHistory.add(order)
    }

    fun getOrderHistory(): List<Order> {
        return orderHistory.toList()
    }
}

// 19. Наследование: Электроника
open class Device(val brand: String) {
    open fun turnOn() {
        println("$brand device turning on")
    }

    open fun turnOff() {
        println("$brand device turning off")
    }
}

class Smartphone(brand: String) : Device(brand) {
    fun takePhoto() {
        println("$brand Smartphone taking a photo")
    }
}

class Laptop(brand: String) : Device(brand) {
    fun openApp() {
        println("$brand Laptop opening app")
    }
}

// 20. Игра "Крестики-нолики"
enum class Cell {
    EMPTY, X, O
}

class Player2(val symbol: Cell, val name: String)

class Game {
    private val board = Array(3) { Array(3) { Cell.EMPTY } }
    private var currentPlayer: Player2? = null

    fun setPlayers(player1:Player2, player2:Player2){
        currentPlayer = player1
    }

    fun printBoard() {
        for (row in board) {
            println(row.joinToString(" | ") {
                when (it) {
                    Cell.EMPTY -> " "
                    Cell.X -> "X"
                    Cell.O -> "O"
                }
            })
            println("---------")
        }
    }

    fun makeMove(row: Int, col: Int): Boolean {
        if (board[row][col] != Cell.EMPTY) {
            println("Cell is already occupied")
            return false
        }

        if (currentPlayer == null){
            println("Setup players first")
            return false
        }

        board[row][col] = currentPlayer!!.symbol
        return true
    }

    fun switchPlayer(player1:Player2, player2:Player2){
        if (currentPlayer == player1){
            currentPlayer = player2
        } else {
            currentPlayer = player1
        }
    }

    fun checkWin():Boolean {
        if (currentPlayer == null){
            println("Setup players first")
            return false
        }

        //Check rows and columns for win
        for (i in 0..2) {
            if (board[i][0] == currentPlayer!!.symbol && board[i][1] == currentPlayer!!.symbol && board[i][2] == currentPlayer!!.symbol){
                return true
            }

            if (board[0][i] == currentPlayer!!.symbol && board[1][i] == currentPlayer!!.symbol && board[2][i] == currentPlayer!!.symbol){
                return true
            }
        }

        if (board[0][0] == currentPlayer!!.symbol && board[1][1] == currentPlayer!!.symbol && board[2][2] == currentPlayer!!.symbol){
            return true
        }

        if (board[0][2] == currentPlayer!!.symbol && board[1][1] == currentPlayer!!.symbol && board[2][0] == currentPlayer!!.symbol){
            return true
        }

        return false
    }

    fun isBoardFull(): Boolean{
        for (row in board){
            for (cell in row){
                if (cell == Cell.EMPTY){
                    return false
                }
            }
        }

        return true
    }

    fun gameFinished(player1:Player2, player2:Player2):String{
        if (checkWin()){
            if (currentPlayer == player1){
                return player1.name + " is the winner!"
            }
             return player2.name + " is the winner!"
        }
        if (isBoardFull()){
            return "It's a draw"
        }

        return "Game is not finished yet!"
    }
}