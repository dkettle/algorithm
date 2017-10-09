class Gcd(object):
    def gcd(self, x, y):
        if x < y:
            return self.gcd(y, x)
        if y == 0:
            return x

        if (x & 1) and (y & 1):
            return self.gcd(x - y, y)
        elif (x & 1) and not (y & 1):
            return self.gcd(x, y >> 1)
        elif not (x & 1) and (y & 1):
            return self.gcd(x >> 1, y)
        else:
            return 2 * self.gcd(x >> 1, y >> 1)
