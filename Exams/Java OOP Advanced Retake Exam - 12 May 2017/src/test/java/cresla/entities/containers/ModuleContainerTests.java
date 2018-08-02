package cresla.entities.containers;

import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Module;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Map;

public class ModuleContainerTests {

    private ModuleContainer moduleContainer;

    @Before
    public void setUp() throws Exception {
        this.moduleContainer = new ModuleContainer(20);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testCapacityOfEmodulesByInput() throws NoSuchFieldException, IllegalAccessException {
        Field energyModules = this.moduleContainer.getClass().getDeclaredField("absorbingModules");

        energyModules.setAccessible(true);

        Map<Integer, AbsorbingModule> moduleMap = (Map<Integer, AbsorbingModule>) energyModules.get(this.moduleContainer);

        this.moduleContainer.addAbsorbingModule(Mockito.mock(AbsorbingModule.class));

        Assert.assertEquals(1, moduleMap.size());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testCapacityOfEnergyModules() throws NoSuchFieldException, IllegalAccessException {
        Field energyModules = this.moduleContainer.getClass().getDeclaredField("energyModules");

        energyModules.setAccessible(true);

        Map<Integer, EnergyModule> moduleMap = (Map<Integer, EnergyModule>) energyModules.get(this.moduleContainer);

        this.moduleContainer.addEnergyModule(Mockito.mock(EnergyModule.class));

        Assert.assertEquals(1, moduleMap.size());
    }


    @Test
    @SuppressWarnings("unchecked")
    public void testAdd() throws NoSuchFieldException, IllegalAccessException {
        Field field = this.moduleContainer.getClass().getDeclaredField("modulesByInput");
        field.setAccessible(true);

        LinkedList<Module> modules = (LinkedList<Module>) field.get(this.moduleContainer);

        this.moduleContainer.addAbsorbingModule(Mockito.mock(AbsorbingModule.class));

        Assert.assertEquals(1, modules.size());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testSet() throws NoSuchFieldException, IllegalAccessException {
        Field field = this.moduleContainer.getClass().getDeclaredField("moduleCapacity");
        field.setAccessible(true);

        int o = (int) field.get(this.moduleContainer);

        Assert.assertEquals(20, o);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void addEnergyModule() throws Throwable {
        EnergyModule energyModule = Mockito.mock(EnergyModule.class);
        Mockito.when(energyModule.getEnergyOutput()).thenReturn(10);
        this.moduleContainer.addEnergyModule(energyModule);

        Field energyModules = this.moduleContainer.getClass().getDeclaredField("energyModules");

        energyModules.setAccessible(true);

        Map<Integer, EnergyModule> moduleMap = (Map<Integer, EnergyModule>) energyModules.get(this.moduleContainer);

        long sum = moduleMap.values().stream().mapToLong(EnergyModule::getEnergyOutput).sum();

        Assert.assertEquals(10L, sum);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void addAbsorbingModule() throws Throwable {
        AbsorbingModule absorbingModule = Mockito.mock(AbsorbingModule.class);
        Mockito.when(absorbingModule.getHeatAbsorbing()).thenReturn(10);
        this.moduleContainer.addAbsorbingModule(absorbingModule);

        Field absorbingModules = this.moduleContainer.getClass().getDeclaredField("absorbingModules");

        absorbingModules.setAccessible(true);

        Map<Integer, AbsorbingModule> moduleMap = (Map<Integer, AbsorbingModule>) absorbingModules.get(this.moduleContainer);

        long sum = moduleMap.values().stream().mapToLong(AbsorbingModule::getHeatAbsorbing).sum();

        Assert.assertEquals(10L, sum);
    }

    @Test
    public void getTotalEnergyOutput() {
        EnergyModule energyModule = Mockito.mock(EnergyModule.class);
        Mockito.when(energyModule.getEnergyOutput()).thenReturn(10);
        Mockito.when(energyModule.getId()).thenReturn(124134);
        this.moduleContainer.addEnergyModule(energyModule);

        EnergyModule energyModule1 = Mockito.mock(EnergyModule.class);
        Mockito.when(energyModule1.getEnergyOutput()).thenReturn(10);
        Mockito.when(energyModule1.getId()).thenReturn(123);
        this.moduleContainer.addEnergyModule(energyModule1);

        long totalEnergyOutput = this.moduleContainer.getTotalEnergyOutput();

        Assert.assertEquals(20L, totalEnergyOutput);
    }

    @Test
    public void getTotalHeatAbsorbing() {
        AbsorbingModule absorbingModule = Mockito.mock(AbsorbingModule.class);
        Mockito.when(absorbingModule.getHeatAbsorbing()).thenReturn(10);
        Mockito.when(absorbingModule.getId()).thenReturn(10);

        AbsorbingModule absorbingModule1 = Mockito.mock(AbsorbingModule.class);
        Mockito.when(absorbingModule1.getHeatAbsorbing()).thenReturn(10);
        Mockito.when(absorbingModule1.getId()).thenReturn(123);

        this.moduleContainer.addAbsorbingModule(absorbingModule);
        this.moduleContainer.addAbsorbingModule(absorbingModule1);

        long totalEnergyOutput = this.moduleContainer.getTotalHeatAbsorbing();

        Assert.assertEquals(20L, totalEnergyOutput);
    }

}
