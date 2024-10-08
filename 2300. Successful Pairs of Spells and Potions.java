
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
    Arrays.sort(potions);
    int[] result = new int[spells.length];

    for (int i = 0; i < spells.length; ++i) {
      long successFactor = (success + spells[i] - 1) / spells[i];
      int startPosition = binarySearch(potions, successFactor);
      result[i] = potions.length - startPosition;
    }
    return result;
  }

  private int binarySearch(int[] potions, long successFactor) {
    int left = 0, right = potions.length;

    while (left < right) {
      int middle = left + (right - left) / 2;

      if (potions[middle] < successFactor)
        left = middle + 1;
      else
        right = middle;
    }
    return right;
  }
