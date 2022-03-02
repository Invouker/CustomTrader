package sk.xpress.customtrader.handlers;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import org.bukkit.craftbukkit.v1_18_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Nbt {

    private static void setNbt_Bool_(@NotNull NBTTagCompound nbt, @NotNull String key, boolean value) {
        int index = key.indexOf('.');
        if(index == -1)
        {
            nbt.a(key, value);
            return;
        }

        String k = key.substring(0, index);
        String subKey = key.substring(index + 1);

        NBTTagCompound child = nbt.p(k);
        if(child == null)
            child = new NBTTagCompound();

        setNbt_Bool_(child, subKey, value);
        nbt.a(k, child);
    }


    private static void setNbt_Double_(@NotNull NBTTagCompound nbt, @NotNull String key, double value) {
        int index = key.indexOf('.');
        if(index == -1) {
            nbt.a(key, value);
            return;
        }

        String k = key.substring(0, index);
        String subKey = key.substring(index + 1);

        NBTTagCompound child = nbt.p(k);
        if(child == null)
            child = new NBTTagCompound();

        setNbt_Double_(child, subKey, value);
        nbt.a(k, child);
    }

    private static void setNbt_Int_(@NotNull NBTTagCompound nbt, @NotNull String key, int value)
    {
        int index = key.indexOf('.');
        if(index == -1)
        {
            nbt.a(key, value);
            return;
        }

        String k = key.substring(0, index);
        String subKey = key.substring(index + 1);

        NBTTagCompound child = nbt.p(k);
        if(child == null)
            child = new NBTTagCompound();

        setNbt_Int_(child, subKey, value);
        nbt.a(k, child);
    }

    private static void setNbt_Long_(@NotNull NBTTagCompound nbt, @NotNull String key, long value)
    {
        int index = key.indexOf('.');
        if(index == -1)
        {
            nbt.a(key, value);
            return;
        }

        String k = key.substring(0, index);
        String subKey = key.substring(index + 1);

        NBTTagCompound child = nbt.p(k);
        if(child == null)
            child = new NBTTagCompound();

        setNbt_Long_(child, subKey, value);
        nbt.a(k, child);
    }

    private static void setNbt_String_(@NotNull NBTTagCompound nbt, @NotNull String key, String value)
    {
        int index = key.indexOf('.');
        if(index == -1)
        {
            nbt.a(key, value);
            return;
        }

        String k = key.substring(0, index);
        String subKey = key.substring(index + 1);

        NBTTagCompound child = nbt.p(k);
        if(child == null)
            child = new NBTTagCompound();

        setNbt_String_(child, subKey, value);
        nbt.a(k, child);
    }

    private static void setNbt_IntArray_(@NotNull NBTTagCompound nbt, @NotNull String key, @NotNull int[] value)
    {
        int index = key.indexOf('.');
        if(index == -1)
        {
            nbt.a(key, value);
            return;
        }

        String k = key.substring(0, index);
        String subKey = key.substring(index + 1);

        NBTTagCompound child = nbt.p(k);
        if(child == null)
            child = new NBTTagCompound();

        setNbt_IntArray_(child, subKey, value);
        nbt.a(k, child);
    }

    private static void setNbt_StringArray_(@NotNull NBTTagCompound nbt, @NotNull String key, @NotNull String[] value)
    {
        int index = key.indexOf('.');
        if(index == -1)
        {
            NBTTagList idsTag = new NBTTagList();
            for (String v : value)
                idsTag.add(NBTTagString.a(v));

            nbt.a(key, idsTag);
            return;
        }

        String k = key.substring(0, index);
        String subKey = key.substring(index + 1);

        NBTTagCompound child = nbt.p(k);
        if(child == null)
            child = new NBTTagCompound();

        setNbt_StringArray_(child, subKey, value);
        nbt.a(k, child);
    }

    public static ItemStack setNbt_Bool(@NotNull ItemStack is, @NotNull String key, boolean value)
    {
        net.minecraft.world.item.ItemStack nms = CraftItemStack.asNMSCopy(is);
        {
            NBTTagCompound compound = nms.s();
            if (compound == null)
                compound = new NBTTagCompound();
            {
                setNbt_Bool_(compound, key, value);
            }
            nms.a(compound);
        }
        return CraftItemStack.asBukkitCopy(nms);
    }

    public static ItemStack setNbt_Double(@NotNull ItemStack is, @NotNull String key, double value)
    {
        net.minecraft.world.item.ItemStack nms = CraftItemStack.asNMSCopy(is);
        {
            NBTTagCompound compound = nms.s();
            if (compound == null)
                compound = new NBTTagCompound();
            {
                setNbt_Double_(compound, key, value);
            }
            nms.a(compound);
        }
        return CraftItemStack.asBukkitCopy(nms);
    }

    public static ItemStack setNbt_Int(@NotNull ItemStack is, @NotNull String key, int value) {

        net.minecraft.world.item.ItemStack nms = CraftItemStack.asNMSCopy(is);
        {
            NBTTagCompound compound = nms.s();
            if (compound == null)
                compound = new NBTTagCompound();
            {
                setNbt_Int_(compound, key, value);
            }
            nms.a(compound);
        }
        return CraftItemStack.asBukkitCopy(nms);
    }

    public static ItemStack setNbt_Long(@NotNull ItemStack is, @NotNull String key, long value)
    {
        net.minecraft.world.item.ItemStack nms = CraftItemStack.asNMSCopy(is);
        {
            NBTTagCompound compound = nms.s();
            if (compound == null)
                compound = new NBTTagCompound();
            {
                setNbt_Long_(compound, key, value);
            }
            nms.a(compound);
        }
        return CraftItemStack.asBukkitCopy(nms);
    }

    public static ItemStack setNbt_String(@NotNull ItemStack is, @NotNull String key, String value)
    {
        net.minecraft.world.item.ItemStack nms = CraftItemStack.asNMSCopy(is);
        {
            NBTTagCompound compound = nms.s();
            if (compound == null)
                compound = new NBTTagCompound();
            {
                setNbt_String_(compound, key, value);
            }
            nms.a(compound);
        }
        return CraftItemStack.asBukkitCopy(nms);
    }

    public static ItemStack setNbt_IntArray(@NotNull ItemStack is, @NotNull String key, @NotNull int[] value)
    {
        net.minecraft.world.item.ItemStack nms = CraftItemStack.asNMSCopy(is);
        {
            NBTTagCompound compound = nms.s();
            if (compound == null)
                compound = new NBTTagCompound();
            {
                setNbt_IntArray_(compound, key, value);
            }
            nms.a(compound);
        }
        return CraftItemStack.asBukkitCopy(nms);
    }

    public static ItemStack setNbt_StringArray(@NotNull ItemStack is, @NotNull String key, @NotNull String[] value)
    {
        net.minecraft.world.item.ItemStack nms = CraftItemStack.asNMSCopy(is);
        {
            NBTTagCompound compound = nms.s();
            if (compound == null)
                compound = new NBTTagCompound();
            {
                setNbt_StringArray_(compound, key, value);
            }
            nms.a(compound);
        }
        return CraftItemStack.asBukkitCopy(nms);
    }

    public static ItemStack setNbt_StringArray(@NotNull ItemStack is, @NotNull String key, List<String> value)
    {
        return setNbt_StringArray(is, key, value.toArray(new String[0]));
    }

    private static boolean getNbt_Bool_(@NotNull NBTTagCompound nbt, @NotNull String key, boolean default_)
    {
        int index = key.indexOf('.');
        if(index == -1)
            return nbt.b(key);

        String k = key.substring(0, index);
        String subKey = key.substring(index + 1);

        if(nbt.e(k))
            return getNbt_Bool_(nbt.p(k), subKey, default_);
        else
            return default_;
    }

    private static double getNbt_Double_(@NotNull NBTTagCompound nbt, @NotNull String key, double default_)
    {
        int index = key.indexOf('.');
        if(index == -1)
            return nbt.k(key);

        String k = key.substring(0, index);
        String subKey = key.substring(index + 1);

        if(nbt.e(k))
            return getNbt_Double_(nbt.p(k), subKey, default_);
        else
            return default_;
    }

    private static int getNbt_Int_(@NotNull NBTTagCompound nbt, @NotNull String key, int default_)
    {
        int index = key.indexOf('.');
        if(index == -1)
            return nbt.h(key);

        String k = key.substring(0, index);
        String subKey = key.substring(index + 1);

        if(nbt.e(k))
            return getNbt_Int_(nbt.p(k), subKey, default_);
        else
            return default_;
    }

    private static long getNbt_Long_(@NotNull NBTTagCompound nbt, @NotNull String key, long default_)
    {
        int index = key.indexOf('.');
        if(index == -1)
            return nbt.h(key);

        String k = key.substring(0, index);
        String subKey = key.substring(index + 1);

        if(nbt.e(k))
            return getNbt_Long_(nbt.p(k), subKey, default_);
        else
            return default_;
    }

    private static String getNbt_String_(@NotNull NBTTagCompound nbt, @NotNull String key, String default_)
    {
        int index = key.indexOf('.');
        if(index == -1)
            return nbt.l(key);

        String k = key.substring(0, index);
        String subKey = key.substring(index + 1);

        if(nbt.e(k))
            return getNbt_String_(nbt.p(k), subKey, default_);
        else
            return default_;
    }

    private static int[] getNbt_IntArray_(@NotNull NBTTagCompound nbt, @NotNull String key, int[] default_)
    {
        int index = key.indexOf('.');
        if(index == -1)
            return nbt.n(key);

        String k = key.substring(0, index);
        String subKey = key.substring(index + 1);

        if(nbt.e(k))
            return getNbt_IntArray_(nbt.p(k), subKey, default_);
        else
            return default_;
    }

    private static String[] getNbt_StringArray_(@NotNull NBTTagCompound nbt, @NotNull String key, String[] default_)
    {
        int index = key.indexOf('.');
        if(index == -1)
        {
            NBTBase tagListBase = nbt.c(key);
            if (tagListBase instanceof NBTTagList)
            {
                NBTTagList tagList = (NBTTagList) tagListBase;
                List<String> list = new ArrayList<>();
                {
                    for (NBTBase nbtVal : tagList)
                    {
                        if (nbtVal == null)
                            list.add(null);
                        else
                            list.add(nbtVal.toString());
                    }
                }
                return list.toArray(new String[0]);
            }
            else
                return default_;
        }

        String k = key.substring(0, index);
        String subKey = key.substring(index + 1);

        if(nbt.e(k))
            return getNbt_StringArray_(nbt.p(k), subKey, default_);
        else
            return default_;
    }

    public static boolean getNbt_Bool(@NotNull ItemStack is, @NotNull String key, boolean default_) {
        net.minecraft.world.item.ItemStack nms = CraftItemStack.asNMSCopy(is);
        {
            NBTTagCompound compound = nms.s();
            if (compound != null)
                return getNbt_Bool_(compound, key, default_);
        }

        return default_;
    }

    public static double getNbt_Double(@NotNull ItemStack is, @NotNull String key, double default_) {
        net.minecraft.world.item.ItemStack nms = CraftItemStack.asNMSCopy(is);
        {
            NBTTagCompound compound = nms.s();
            if (compound != null)
                return getNbt_Double_(compound, key, default_);
        }

        return default_;
    }

    public static int getNbt_Int(@NotNull ItemStack is, @NotNull String key, int default_) {
        net.minecraft.world.item.ItemStack nms = CraftItemStack.asNMSCopy(is);
        {
            NBTTagCompound compound = nms.s();
            if (compound != null)
                return getNbt_Int_(compound, key, default_);
        }

        return default_;
    }

    public static long getNbt_Long(@NotNull ItemStack is, @NotNull String key, long default_)
    {
        net.minecraft.world.item.ItemStack nms = CraftItemStack.asNMSCopy(is);
        {
            NBTTagCompound compound = nms.s();
            if (compound != null)
                return getNbt_Long_(compound, key, default_);
        }

        return default_;
    }

    public static int getNbt_Int(@NotNull ItemStack is, @NotNull String key)
    {
        return getNbt_Int(is, key, 0);
    }

    public static String getNbt_String(@NotNull ItemStack is, @NotNull String key, String default_) {
        net.minecraft.world.item.ItemStack nms = CraftItemStack.asNMSCopy(is);
        {
            NBTTagCompound compound = nms.s();
            if (compound != null)
                return getNbt_String_(compound, key, default_);
        }

        return default_;
    }


    public static String getNbt_String(@NotNull ItemStack is, @NotNull String key)
    {
        return getNbt_String(is, key, null);
    }

    public static int[] getNbt_IntArray(@NotNull ItemStack is, @NotNull String key, int[] default_)
    {
        net.minecraft.world.item.ItemStack nms = CraftItemStack.asNMSCopy(is);
        {
            NBTTagCompound compound = nms.s();
            if (compound != null)
                return getNbt_IntArray_(compound, key, default_);
        }

        return default_;
    }

    public static int[] getNbt_IntArray(@NotNull ItemStack is, @NotNull String key)
    {
        return getNbt_IntArray(is, key, null);
    }

    public static String[] getNbt_StringArray(@NotNull ItemStack is, @NotNull String key, String[] default_)
    {
        net.minecraft.world.item.ItemStack nms = CraftItemStack.asNMSCopy(is);
        {
            NBTTagCompound compound = nms.s();
            if (compound != null)
                return getNbt_StringArray_(compound, key, default_);
        }

        return default_;
    }

    public static String[] getNbt_StringArray(@NotNull ItemStack is, @NotNull String key)
    {
        return getNbt_StringArray(is, key, null);
    }
}