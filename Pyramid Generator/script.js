console.log("Let's build a pyramid using JavaScript basics:");
console.log("    #    ");
console.log("   ###   ");
console.log("  #####  ");
console.log(" ####### ");
console.log("#########");

let character = "Hello";
console.log(character);
character ="World"
console.log(character);

let secondCharacter;
secondCharacter ="Test"
secondCharacter = character;
console.log(secondCharacter)

let profession="teacher";
let age;
console.log(profession)
console.log(age)

// let count = 8
console.log(count + 1)

let rows = ["Naomi","Quincy","CamperChan"];
rows.push("freeCodeCamp")
console.log(rows[0])
rows[rows.length-1] = 10;
let popped = rows.pop()
console.log(popped)
console.log(rows)

let cities = ["London", "New York", "Mumbai"];
console.log(cities);
cities[cities.length - 1] = "Mexico City";
console.log(cities);

let pushed = rows.push("freeCodeCamp");
console.log(pushed)

// const character = "#";
const count = 8;
const rows = [];

for (let i=0; i<count; i=i+1){
    // console.log(i)
    rows.push(padRow(i+1, count));
}
let result="";


// const row ;
for( const row of rows){
    result= result + row +"\n";
}

console.log(result);

// function padRow(name) {
//     const test = "Testing";
//     console.log("This works!");
//     return test;
//     console.log("This works!");
// }
 
function padRow(rowNumber, rowCount) {
    return " ".repeat(rowCount-rowNumber) + character.repeat(2 * rowNumber - 1) + " ".repeat(rowCount-rowNumber);
  }


function addTwoNumbers(num1,num2){
    return num1 + num2;
  }
  let sum = addTwoNumbers(5,10);
  console.log(sum);

padRow();
const call=padRow();
padRow("Ramsey");

console.log(call);

if ("") {
  console.log("Condition is true");
} else if (5 < 10) {
  console.log("5 is less than 10");
} else {
  console.log("This is the else block");
}

/*while (rows.length < count) {
  rows.push(padRow(rows.length + 1, count));
}*/
const numbers = [1, 2, 3];
const shifted = numbers.shift();
console.log(shifted);
const unshifted = numbers.unshift(5);
console.log(unshifted);
console.log(numbers);