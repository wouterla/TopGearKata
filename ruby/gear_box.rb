# Top Gear Refactoring Kata
# =========================
#
# This is a refactoring challenge where we look at a single-method
# case, which is untested, needs refactoring, and is hard to read. Oh,
# and contains bugs;-)
#
# The assignment is as follows
# ----------------------------
#
# This is the code for our customer's new environmentally friendly electric car.
# The car is very dependent on software for almost everything, and the part that we're
# working on is the automatic gear box. The code you see is the automatic gear box, which
# currently shifts up if the engine goes over 2000 rpm, and down if it goes under 500.
#
# For our this new car, it's been determined that the choice of gear can be much
# more efficient if we could just set more specific ranges of rpm for each gear.
# Future versions of the car could then use actual measurements of fuel consumption
# to configure those ranges on the fly!
# Your assignment is to make the gearbox accept a range of rpms for each gear (and
# of course use that range to shift gears!)
class GearBox

  def initialize
    @s = 0
    @e = 0
  end

  def doit(i)
    if @s < 0
      # do nothing!
      @e = i
    else
      if @s > 0
        if i > 2000
          @s += 1
        elsif i < 500
          @s -= 1
        end
      if @s > 6
        @s -= 1
      elsif @s < 1
        @s += 1
      end
      @e = i
      end
     end
   end
end
