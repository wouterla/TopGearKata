using System;
using Xunit;
using TopGear = TopGearKata.TopGear;

namespace TopGearKataTest
{
    public class TopGearTest
    {
        [Fact]
        public void TestSomething()
        {
            // Arrange
            TopGear gear = new TopGear();
            
            // Act
            gear.Doit(1);
            
            // Assert
            Assert.Equal(1, 1);
        }
    }
}