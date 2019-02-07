using System;

namespace TopGearKata
{
    class Program
    {
        static void Main(string[] args)
        {
            var gear = new TopGear();
            
            // Act
            gear.Doit(1);

            Console.WriteLine("Wroooom!");
        }
    }
}