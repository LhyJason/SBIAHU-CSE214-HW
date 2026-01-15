/**
 * @author: Hanyang Liu
 * @ID number: R22114061
 * @recitation: 0
 *              VectorADT class
 */

public class VectorADT implements Cloneable {

    /**
     * Construct an instance of the VectorADT class VectorADT of a certain size with
     * all elements set to 0.
     * 
     * @param size
     *             the size that this <CODE>VectorADT</CODE> will be
     *             <dt><b>Precondition: size is between 1 and MAX_ELEMENTS,
     *             inclusive.
     *             <dt><b>Postcondition:This has been set to
     *             the zero vector (all elements are zero) of with a size equal to
     *             the parameter.
     * @exception InvalidSizeException
     *                                 Indicates that size is not within the valid
     *                                 range.
     */
    // members
    private int size;
    private int[] vector;
    private final int MAX_ELEMENTS = 60;

    // constructor
    /* method of clone */
    /**
     * Generates a copy of this VectorADT.
     * 
     * @param newVector
     *                  the vector that clone from the orgin vector
     *                  <dt>Precondition: int[] type and is the same length of orgin
     *                  vector length
     * @param v
     *                  class type is VectorADT and record the data of newVector
     * 
     * @return
     *         The return value is a copy of this VectorADT. Subsequent changes to
     *         the copy will not affect the original, nor vice versa. Note that the
     *         return value must be typecast to a VectorADT before it can be used.
     * 
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        int[] vector = this.vector;
        int[] newVector = new int[vector.length];
        for (int i = 0; i < vector.length; i++) {
            newVector[i] = vector[i];
        }
        try {
            VectorADT v = (VectorADT) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("...");
        }

        v.vector = newVector;
        return v;
    }

    /* method of equals */
    /**
     * Compare this VectorADT to another object for equality.
     * 
     * @param obj
     *               an object to which this VectorADT is compared
     * @param v
     *               a cast of object to VectorADT
     * @param result
     *               the result of whether two int[] are the same or not
     * 
     * @return
     *         A return value of true indicates that obj refers to a VectorADT
     *         object with the same values and size as this VectorADT. Otherwise,
     *         the return value is false.
     * 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VectorADT v = (VectorADT) obj;
        boolean result = false;
        for (int i = 0; i < vector.length; i++) {
            result = vector[i] == v.vector[i];
            if (result == false) {
                break;
            }
        }
        return size == v.size && result;
    }

    /**
     * Construct an instance of the VectorADT class of a certain size with all
     * elements set to 0.
     * 
     * @param size
     *             the size that this VectorADT will be
     *             <dt>Precondition:This VectorADT has been set to the zero
     *             vector (all elements are zero) of with a size equal to the
     *             parameter.
     * @throws InvalidSizeException
     *                              Indicates that size is not within the valid
     *                              range.
     */
    public VectorADT(int size) throws InvalidSizeException {

        if (size < 1 || size > MAX_ELEMENTS) {
            throw new InvalidSizeException();
        }
        this.size = size;
        vector = new int[size];
        for (int i = 0; i < vector.length; i++) {
            vector[i] = 0;
        }

    }

    /* getters and setters */

    /**
     * Sets the element associated with the given position for this VectorADT.
     * 
     * @param value
     *                new value for the element in this VectorADT element
     * @param element
     *                position of the element to alter in this VectorADT
     * 
     *                <dt><b>Preconditions:
     *                This object has been instantiated and element is a valid
     *                element (between 0 and the size of this VectorADT -
     *                1, inclusive).
     *                <dt><b>Postcondition:
     *                Sets the value of the given element in this VectorADT to the
     *                given value.
     * @throws IllegalArgumentException
     *                                  Indicates that element does not correspond
     *                                  to a
     *                                  validposition of the array.
     */
    public void setElement(int value, int element) throws IllegalArgumentException {
        if (element < 0 || element > vector.length - 1) {
            throw new IllegalArgumentException("Element does not correspond to a valid position of the array");
        }
        vector[element] = value;
    }

    /**
     * Gets the element associated with the given position for this VectorADT.
     * 
     * @param element
     *                position of the element to access in this VectorADT
     *                <dt>Preconditions:
     *                This object has been instantiated and element is a valid
     *                element (between 0
     *                and the size of this VectorADT - 1, inclusive).
     * @return
     *         The value of the given element in this VectorADT.
     * @throws IllegalArgumentException
     *                                  Indicates that element does not correspond
     *                                  to a valid position of the array.
     */
    public int getElement(int element) throws IllegalArgumentException {
        if (element < 0 || element > vector.length - 1) {
            throw new IllegalArgumentException("Element does not correspond to a valid position of the array");
        }
        return vector[element];
    }

    /* getter of size */
    /**
     * Returns the size of this VectorADT.
     * 
     * @return
     *         The size of this VectorADT object.
     */
    public int getSize() { //
        return this.size;
    }

    /* method of add */
    /**
     * Generates and returns the sum of two given VectorADTs. Note that vector
     * addition is defined by adding the corresponding elements of each vector to
     * get the corresponding element of the sum vector.
     * 
     * @param v1
     *                  the first VectorADT
     * @param v2
     *                  the second VectorADT
     *                  <dt>Preconditions:
     *                  The VectorADT objects referred to by v1 and v2 have been
     *                  instantiated and both have the same size.
     * @param vectorAdd
     *                  the result of add
     * @return
     *         A VectorADT containing the sum of the two given VectorADT parameters
     *         (v1 + v2).
     * @throws IllegalArgumentException
     *                                  Indicates that either v1 or v2 is null.
     * 
     * @throws InvalidSizeException
     *                                  Indicates that v1 and v2 are of different
     *                                  sizes.
     */
    public static VectorADT add(VectorADT v1, VectorADT v2) throws IllegalArgumentException, InvalidSizeException {
        if (v1.getSize() != v2.getSize()) {
            throw new InvalidSizeException("v1 and v2 are of different sizes");
        }
        if (v1 == null || v2 == null) {
            throw new IllegalArgumentException("either v1 or v2 is null");
        }

        VectorADT vectorAdd = new VectorADT(v1.getSize());
        for (int i = 0; i < vectorAdd.getSize(); i++) {
            vectorAdd.setElement(v1.getElement(i) + v2.getElement(i), i);
        }
        return vectorAdd;

    }

    /* method of subtract */
    /**
     * Generates and returns the difference of two given VectorADTs. Note that
     * vector subtraction is defined by subtracting the corresponding elements of
     * each vector to get the corresponding element of the difference vector.
     * 
     * @param v1
     *                       the first VectorADT
     * @param v2
     *                       the second VectorADT
     *                       <dt>Preconditions:
     *                       The VectorADT objects referred to by v1 and v2 have
     *                       been
     *                       instantiated and both have the same size.
     * @param vectorSubtract
     *                       the result of method
     * @return
     *         A VectorADT containing the difference of the two given VectorADT
     *         parameters (v1 - v2).
     * @throws IllegalArgumentException
     *                                  Indicates that either v1 or v2 is null.
     * @throws InvalidSizeException
     *                                  Indicates that v1 and v2 are of different
     *                                  sizes.
     */
    public static VectorADT subtract(VectorADT v1, VectorADT v2) throws IllegalArgumentException, InvalidSizeException {
        if (v1.getSize() != v2.getSize()) {
            throw new InvalidSizeException("v1 and v2 are of different sizes");
        }
        if (v1 == null || v2 == null) {
            throw new IllegalArgumentException("either v1 or v2 is null");
        }

        VectorADT vectorSubtract = new VectorADT(v1.getSize());
        for (int i = 0; i < vectorSubtract.getSize(); i++) {
            vectorSubtract.setElement(v1.getElement(i) - v2.getElement(i), i);
        }
        return vectorSubtract;
    }

    /* method of multiplyByScalar */
    /**
     * Generates and returns the product of a VectorADTs and a scalar (i.e., regular
     * number). Note that multiplication by a scalar is to multiply each element in
     * the vector by the scalar number.
     * 
     * @param v
     *               the VectorADT
     * @param scalar
     *               the scalar to multiply the VectorADT by
     *               <dt>Precondition:
     *               The VectorADT object referred to by vector has been
     *               instantiated.
     * @param vTemp
     *               temporary vector record clone
     * @param result
     *               result of method
     * @return
     *         A VectorADT containing the product of the VectorADT and the scalar.
     * @throws CloneNotSupportedException
     *                                    cannot clone
     */
    public static VectorADT multiplyByScalar(VectorADT v, int scalar) throws CloneNotSupportedException {
        if (v == null) {
            return null;
        }
        VectorADT vTemp = (VectorADT) v.clone();
        VectorADT result = vTemp.multiply(vTemp, scalar);
        return result;
    }

    /* multiply */
    /**
     * genereates the result of mutiply
     * 
     * @param v
     *               the VectorADT
     * @param scalar
     *               the scalar to multiply the VectorADT by
     * @return
     *         return the result of calculating
     */
    public VectorADT multiply(VectorADT v, int scalar) {
        for (int i = 0; i < v.getSize(); i++) {
            int newValue = v.getElement(i) * scalar;
            v.setElement(newValue, i);
        }
        return v;
    }

    /* method of dotProduct */
    /**
     * Generates and returns the dot product of two given VectorADTs. Note that the
     * dot product is defined as the sum of all the products of corresponding
     * elements in the two vectors, shown as follows:
     * 
     * (v1[0] * v2[0]) + (v1[1] * v2[1]) + … + (v1[v1.getSize() - 1] *
     * v2[v2.getSize() - 1])
     * 
     * @param v1
     *           the first VectorADT
     * @param v2
     *           the second VectorADT
     *           Preconditions:
     * 
     *           <dt>The VectorADT objects referred to by v1 and v2 have been
     *           instantiated and both have the same size.
     * @return
     *         The dot product of the two given VectorADT parameters.
     * @throws IllegalArgumentException
     *                                  Indicates that either v1 or v2 is null.
     * @throws InvalidSizeException
     *                                  Indicates that v1 and v2 are of different
     *                                  sizes.
     */
    public static int dotProduct(VectorADT v1, VectorADT v2) throws IllegalArgumentException, InvalidSizeException {
        if (v1.getSize() != v2.getSize()) {
            throw new InvalidSizeException("v1 and v2 are of different sizes");
        }
        if (v1 == null || v2 == null) {
            throw new IllegalArgumentException("either v1 or v2 is null");
        }

        int sum = 0;
        for (int i = 0; i < v1.size; i++) {
            sum += v1.getElement(i) * v2.getElement(i);
        }
        return sum;
    }

    /* method of toString */
    /**
     * Returns a String representation of this VectorADT.
     * 
     * @param result
     *               the final String
     * @return
     *         The elements of this VectorADT in order from element 0 to element
     *         getSize() - 1, each separated by spaces.
     */
    public String toString() {
        String result = "";
        for (int i = 0; i < vector.length; i++) {
            if (i == vector.length - 1) {
                result += vector[i];
                break;
            }
            result += (vector[i] + " ");
        }

        return result;
    }
}
